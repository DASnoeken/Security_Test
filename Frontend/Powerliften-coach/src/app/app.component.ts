import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Powerliften-coach';
  showScherm(a: number) {
    if (a == 1) {
      document.getElementById("planning").hidden = false;
      document.getElementById("oefening").hidden = true;
      document.getElementById("voortgang").hidden = true;
    } else if (a == 2){
      document.getElementById("planning").hidden = true;
      document.getElementById("oefening").hidden = false;
      document.getElementById("voortgang").hidden = true;
    } else {
      document.getElementById("planning").hidden = true;
      document.getElementById("oefening").hidden = true;
      document.getElementById("voortgang").hidden = false;
    }

  }
}
