import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: string;
  password: string;
  login: boolean = false;


  constructor() { }

  ngOnInit(): void {
  }

  checkLogin(): void{
    if(this.userName == "WVWZZZ1KZDP045466" && this.password == "rootPass123!"){
      this.login = true;
    }
  }

}
