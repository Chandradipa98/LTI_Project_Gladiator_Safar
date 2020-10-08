import { Reservation } from './../payment/Reservation';
export class Payment{
    paymentId:number;
    addedFare:number;
    res:Reservation;
    dayDifference:number;
    chargedFare:number;
    paymentMethod:string;

    constructor(addedFare:number, res:Reservation, dayDifference:number, chargedFare:number,
        paymentMethod:string){
            this.addedFare=addedFare;
            this.res=res;
            this.dayDifference=dayDifference;
            this.chargedFare=chargedFare;
            this.paymentMethod=paymentMethod;
    }
}