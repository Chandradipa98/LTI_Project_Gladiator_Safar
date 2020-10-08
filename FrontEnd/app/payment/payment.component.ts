import { Seat } from './../seat-layout/Seat';
import { SeatService } from './../seat.service';
import { PaymentService } from './../payment.service';
import { Payment } from './../seat-layout/Payment';
import { RegisterService } from './../register.service';
import { BusService } from './../bus.service';
import { Bus } from './../admin/Bus';
import { DatePipe } from '@angular/common';
import { ReservationService } from './../reservation.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Reservation } from './Reservation';
import { Register } from '../register/Register';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {


  id: number;
  cardForm: FormGroup;
  upiForm: FormGroup;
  netBankForm: FormGroup;
  res: Reservation[] = new Array();
  date: Date;
  myDate: Date = new Date();
  seats: number;
  fare: number;
  email: string;
  phone: string;
  bus: Bus;
  bus1:Bus;
  busid: number;
  depDate: string;
  resv: Reservation;
  reg:Register;
  regEmail:string;
  ds:number=0;
  daydifference:number;
  addedFare:number=1000;
  chargedFare:number;
  seat1:Seat[] = new Array();
  sl:number;
  payMethod:string;
  constructor(private fb: FormBuilder, private router: Router, private service: ReservationService, private busService: BusService, private userService: RegisterService, private payService:PaymentService, private seatService:SeatService) { }

  ngOnInit(): void {
    this.cardForm = this.fb.group({
      cardHolderName: ['', Validators.required],
      cardNumber: ['', Validators.required],
      cvv: ['', Validators.required],
      validTill: ['', Validators.required],
    });
    this.upiForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phoneNo: ['', Validators.required],
      upi: ['', Validators.required]
    });
    this.netBankForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      bankName: ['', Validators.required],
      ifsc: ['', Validators.required],
    });
    //alert(this.date)
    this.busid = Number(sessionStorage.getItem('busid'));
    this.depDate = sessionStorage.getItem("busdd");
    this.regEmail = localStorage.getItem("username");
    this.busService.getBusByIdDate(this.busid, this.depDate).subscribe(data => {
      this.bus = data;
    });

    this.service.getReservation().subscribe(data => {
      this.res = data;
    });

    this.userService.getRegistrationById(this.regEmail).subscribe(data =>{
      this.reg = data;
    });

   /* this.seatService.getSeatByIdDate(this.busid,this.depDate).subscribe(data =>{
      this.seat1=data;
    });*/

  }


  show(id) {
    for (var i = 1; i <= 3; i++) {
      document.getElementById('show' + i).style.display = 'none';
    }
    document.getElementById('show' + id).style.display = 'block';
    if(id==1){
      this.payMethod="Credit Card";
    }else if(id == 2){
      this.payMethod="UPI";
    }else{
      this.payMethod="Net Banking";
    }
  }


  Book() {
    //this.count();
    this.seats = Number(sessionStorage.getItem('seat'));
    this.fare = Number(sessionStorage.getItem('fare'));
    
    this.email = sessionStorage.getItem('email');
    this.phone = sessionStorage.getItem('phone');
    
    this.ds=Number(sessionStorage.getItem('driverStatus'));
    
    this.date = new Date(this.bus.departureDate);
    this.daydifference= this.date.getDate() - this.myDate.getDate();
    
    this.chargedFare=this.addedFare-this.daydifference*10;
    
    //alert(sessionStorage.getItem('phone'))
    if (localStorage.getItem("username") != null) {
      this.resv = new Reservation(this.seats, 1, this.ds, null, 0, this.fare+this.chargedFare, this.reg.emailId, this.reg.phoneNo, this.bus, this.reg);
      //alert(JSON.stringify(this.resv))
      /*this.service.addReservation(this.resv).subscribe(data => {
        //alert("data: "+JSON .stringify(this.userForm.value));
        this.res.push(this.resv);
      });*/
    } else {
      this.resv = new Reservation(this.seats, 1, 0, null, 0, this.fare, this.email, this.phone, this.bus, null);
      //alert(JSON.stringify(this.resv))
      /*this.service.addReservation(this.resv).subscribe(data => {
        //alert("data: "+JSON .stringify(this.userForm.value));
        this.res.push(this.resv);
      });*/
      
    }
   this.sl=this.seat1.length;
   let pay:Payment = new Payment(this.addedFare,this.resv,this.daydifference, this.addedFare-this.daydifference*10,this.payMethod);
    this.payService.addPay(pay).subscribe(data =>{
      //alert(JSON.stringify(pay));
    });

    this.bus1= new Bus(this.bus.id, this.bus.source, this.bus.destination, this.bus.arrivalTime, this.bus.departureTime, this.bus.arrivalDate, 
      this.bus.departureDate, this.bus.availableSeat-this.seats, this.bus.totalSeat, this.bus.baseFare, this.bus.busStatus, this.bus.coachBusStatus);
    this.busService.updateBus(this.bus1).subscribe(data =>{
      
    });
    sessionStorage.removeItem('driverStatus');
    /*for (let index = 0; index < this.seats; index++) {
      let seat:Seat = new Seat(this.sl+1,this.resv,this.bus);
      this.sl=this.sl+1;
      this.seatService.addSeat(seat).subscribe(data =>{

      });
    }*/
    
    this.router.navigate(['/payment-success'])
    
  }
  back(){
    this.router.navigate(['seat-layout']);
  }
}
