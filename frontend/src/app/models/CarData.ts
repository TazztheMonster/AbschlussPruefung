import { GpsPosition } from "./GpsPosition";
import { Mileage } from "./Mileage";

export class CarData{

  vin: string = '';
  gpsPosition: GpsPosition;
  embt: number; // electromotive belt tensioning
  lightOperatingHours: number;
  mileage: Mileage;
  tirePressure: number;
  temperature: number;
  nodsa: number; //number of driver seat adjustments
  nomi: number; //number of media inserted
  sblc: number; //starter battery loading cycles

  constructor(){

    this.gpsPosition = new GpsPosition();
    this.mileage = new Mileage();

  }

}
