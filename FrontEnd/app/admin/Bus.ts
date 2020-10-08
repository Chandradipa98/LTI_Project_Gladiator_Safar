export class Bus{
      id:number;
      source: string;
      destination:string;
      arrivalTime: string;
      departureTime:string;
      arrivalDate:Date;
      departureDate:Date;
      availableSeat:number;
      totalSeat:number;
      baseFare:number;
      busStatus:number;
      coachBusStatus:number;

      constructor(id:number, source: string,destination:string,arrivalTime: string,
        departureTime:string, arrivalDate:Date, departureDate:Date,
        availableSeat:number,totalSeat:number, baseFare:number,  busStatus:number,
        coachBusStatus:number)
      {
        this.id=id;
        this.source= source;
        this.destination=destination;
        this.arrivalTime=arrivalTime;
        this.departureTime=departureTime;
        this.arrivalDate=arrivalDate;
        this.departureDate=departureDate;
        this.availableSeat=availableSeat;
        this.totalSeat=totalSeat;
        this.baseFare=baseFare;
        this.busStatus=busStatus;
        this.coachBusStatus=coachBusStatus;
      }

     
}