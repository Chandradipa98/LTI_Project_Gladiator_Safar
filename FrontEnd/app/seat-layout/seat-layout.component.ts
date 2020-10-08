import { Router } from '@angular/router';
import { Bus } from './../admin/Bus';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seat-layout',
  templateUrl: './seat-layout.component.html',
  styleUrls: ['./seat-layout.component.css']
})
export class SeatLayoutComponent implements OnInit {
  
  seatForm:FormGroup;
  bus:Bus;
  id:number;
  source:string;
  destination:string;
  DateOfJrny:string;
  arrivalTime:string;
  departureTime:string;
  seat:number;
  fare:number;
  totalFare:number;
  constructor(private fb: FormBuilder, private router:Router) { }

  ngOnInit(): void {
    this.seatForm = this.fb.group({
      noOfSeats: ['', Validators.required],
  });
  //alert(JSON.stringify(sessionStorage.getItem('busid')));
  this.id = Number(sessionStorage.getItem('busid'));
  this.source = sessionStorage.getItem('bussrc');
  this.destination = sessionStorage.getItem('busdest');
  this.DateOfJrny = sessionStorage.getItem('busdd');
  this.arrivalTime = sessionStorage.getItem('busat');
  this.departureTime = sessionStorage.getItem('busdt');
  this.fare = Number(sessionStorage.getItem('busbf'));
  }
  

show(id) {  
  //this.seat = this.seatForm.controls.noOfValue.value;
  this.totalFare = this.seat * this.fare;
  document.getElementById('show'+id).style.display = 'block';
}

proceed(){
  sessionStorage.setItem('fare',this.totalFare.toString());
  sessionStorage.setItem('seat',this.seat.toString());
  this.router.navigate(['payment-portal']);
}

back(){
    this.router.navigate(['search-bus-page']);
  }


}
