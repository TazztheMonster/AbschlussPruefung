import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CarData } from '../../models/CarData';

@Component({
  selector: 'app-carData',
  templateUrl: './carData.component.html',
  styleUrls: ['./carData.component.css']
})
export class CarDataComponent implements OnInit {

  selectedVIN: string = '';
  carData: CarData[];
  numberOfDataSets: number[];
  selectedAmount: number;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.carData = [];
    this.numberOfDataSets = [1, 2, 3, 4, 5];
    this.selectedAmount = 1;
  }

  getCarDataByVIN(): void {
    console.log("Vin " + this.selectedVIN + "mit " + this.selectedAmount + "Datensätzen ausgelesen.");
    this.carData = [];
    this.http.get<CarData[]>("/adl-api/v1/cars/" + this.selectedVIN + "/" + this.selectedAmount).toPromise().then(data => {
      data.forEach(e => {
        let carToAdd = { vin: e.vin,
          gpsPosition: { lon: e.gpsPosition.lon, lat: e.gpsPosition.lat },
          fillLevels: { fuel: e.fillLevels.fuel, washingWater: e.fillLevels.washingWater, brakeFluid: e.fillLevels.brakeFluid, coolant: e.fillLevels.coolant},
          embt: e.embt, lightOperatingHours: e.lightOperatingHours,
          mileage: { autobahn: e.mileage.autobahn, city: e.mileage.city, country: e.mileage.country },
          tirePressure: e.tirePressure, temperature: e.temperature, nodsa: e.nodsa, nomi: e.nomi, sblc: e.sblc};
        this.carData.push(carToAdd);
      })
    })
  }
}
