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
    this.http.post<GenericDataClass>("http://localhost:8080/add", this.genericDataObject).toPromise().then(data => {
      this.genericDataObject = data;
    })
  }

  getGenericDataObjectByID(): void {
    console.log("ausgelesen.")
    this.http.get<GenericDataClass>("http://localhost:8080/get/" + this.genericDataObject.data1).toPromise().then(data => {
      this.genericDataObject = data;
    })
  }
}
