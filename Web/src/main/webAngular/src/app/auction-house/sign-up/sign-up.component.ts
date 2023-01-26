import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  form: any = {
    username: null,
    email: null,
    password: null,
    phone_number: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  user: User = new User();

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {

      console.log(this.user);


      this.authService.register(this.form.username, this.form.password, this.form.phone_number, this.form.email).subscribe(
        data => {
        console.log("nie: ");
          console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
        },
        err => {
        console.log("error: ");
          console.log(err);
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
        }
      );
    }

}
