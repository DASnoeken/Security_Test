import { Injectable } from '@angular/core';
import { Coach } from './coach';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class CoachService{
    constructor(private http : HttpClient){}

    //GET
    getCoach(id:number) : Observable<Coach>{
        console.log(id);
        return this.http.get<Coach>("http://localhost:8082/getCoach/"+id);
    }
}