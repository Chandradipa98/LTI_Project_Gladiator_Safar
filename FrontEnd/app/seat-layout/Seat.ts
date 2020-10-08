import { CancelTicket } from './../cancel-ticket/CancelTicket';
import { Bus } from './../admin/Bus';
export class Seat{
    serialNo:number;
    seatId:number;
    reserve:CancelTicket;
    busDetails:Bus;

    constructor(seatId:number, reserve:CancelTicket, busDetails:Bus){
        this.seatId = seatId;
        this.reserve = reserve;
        this.busDetails = busDetails;
    }
}