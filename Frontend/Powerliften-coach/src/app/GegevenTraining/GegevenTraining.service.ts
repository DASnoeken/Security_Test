import { Injectable } from '@angular/core';
import { GegevenTraining } from './GegevenTraining';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Oefening } from '../Oefening/oefening';

@Injectable()
export class GegevenTrainingService{
    
    
    constructor(private http : HttpClient){}

    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    }

    getOefeningByID(id: number):Observable<Oefening> {
        return this.http.get<Oefening>("http://localhost:8082/getOefening/" + id);
    }

    getOefeningen():Observable<Oefening[]>{
        return this.http.get<Oefening[]>("http://localhost:8082/allOefeningen")
    }

    
}