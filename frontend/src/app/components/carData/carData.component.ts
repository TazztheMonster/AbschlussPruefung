import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CarData } from '../../models/CarData';

@Component({
  selector: 'app-carData',
  templateUrl: './carData.component.html',
  styleUrls: ['./carData.component.css']
})
export class CarDataComponent implements OnInit {

  carData: CarData;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.carData = new CarData();
  }

  getCarDataByVIN(): void {
    console.log("Vin " + this.carData.vin + " ausgelesen.")
    this.http.get<CarData>("/adl-api/v1/cars/" + this.carData.vin).toPromise().then(data => {
      this.carData = { vin: data.vin,
                      gpsPosition: { lon: data.gpsPosition.lon, lat: data.gpsPosition.lat },
                      fillLevels: { fuel: data.fillLevels.fuel, washingWater: data.fillLevels.washingWater, brakeFluid: data.fillLevels.brakeFluid, coolant: data.fillLevels.coolant},
                      embt: data.embt, lightOperatingHours: data.lightOperatingHours,
                      mileage: { autobahn: data.mileage.autobahn, city: data.mileage.city, country: data.mileage.country },
                      tirePressure: data.tirePressure, temperature: data.temperature, nodsa: data.nodsa, nomi: data.nomi, sblc: data.sblc};
    })
  }
}
