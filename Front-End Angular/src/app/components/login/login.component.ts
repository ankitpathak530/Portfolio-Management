import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';
import { AuthResponse } from 'src/app/model/authResponse';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg: string = ''
  credentials = {
    username: '',
    password: ''
  }
  constructor(private loginService: LoginService, private router: Router, private snack: MatSnackBar) { }

  ngOnInit(): void {
  }
  onSubmit() {
    if ((this.credentials.username != '' && this.credentials.password != '')
      && (this.credentials.username != null && this.credentials.password != null)) {


      console.log("Have to Submit Form the server");
      //token generated
      this.loginService.generateToken(this.credentials).subscribe(
        (response: AuthResponse) => {
          console.log(response);
          this.loginService.loginUser(response["jwttoken"]);
          console.log(this.loginService.getToken());
          //this.router.navigate(['dashboard', (this.credentials.username])
          // this.router.navigate(['dashboard'])
          window.location.href = "/dashboard";

        },
        (error: any) => {
          console.log(error);
          this.msg = "Invalid Credentials"
        }
      )
    }
    else {
      this.snack.open('Username or password is empty', "", {
        duration: 3000,
      });
      return;
    }
  }
}
