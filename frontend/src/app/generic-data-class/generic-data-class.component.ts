import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { GenericDataClass } from '../models/GenericDataClass';

@Component({
  selector: 'app-generic-data-class',
  templateUrl: './generic-data-class.component.html',
  styleUrls: ['./generic-data-class.component.css']
})
export class GenericDataClassComponent implements OnInit {

  genericDataObject: GenericDataClass;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.genericDataObject = new GenericDataClass();
  }

  saveGenericDataObject(): void {
    console.log("gespeichert");
    this.http.post<GenericDataClass>("http://localhost:8080/genericData/add", this.genericDataObject).toPromise().then(data => {
      this.genericDataObject = { data1: data.data1, data2: data.data2, data3: data.data3 };
    })
  }

  getGenericDataObjectByID(): void {
    console.log("ausgelesen.")
    this.http.get<GenericDataClass>("http://localhost:8080/genericData/get/" + this.genericDataObject.data1).toPromise().then(data => {
      this.genericDataObject = { data1: data.data1, data2: data.data2, data3: data.data3 };
    })
  }
}
