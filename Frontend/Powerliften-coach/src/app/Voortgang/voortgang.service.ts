import { Injectable } from '@angular/core';
import { Voortgang } from './voortgang';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class VoortgangService{
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    }

    //GET
    getAllVoortgang() : Observable<Voortgang>{
        console.log("getAllVoortgang()");
        return this.http.get<Voortgang>("http://localhost:8082/allVoortgang");
    }

    //GET
    bekijkID(id:number):Observable<Voortgang>{
        return this.http.get<Voortgang>("http://localhost:8082/checkID/"+id);
    }

    //POST
    geefFeedback(feedback:string,id:number) : Observable<Voortgang>{
        var voortgangObject = {voortgangObject};
        voortgangObject.id = id;
        voortgangObject.feedback = feedback;
        return this.http.post<Voortgang>("http://localhost:8082/geefFeedback",JSON.stringify(voortgangObject),this.httpOptions);
    }

    constructor(private http: HttpClient){}
}