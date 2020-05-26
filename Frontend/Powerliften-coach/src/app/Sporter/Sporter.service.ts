import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Sporter } from './Sporter';
import { Observable } from 'rxjs';

@Injectable()
export class SporterService{
    constructor(private http : HttpClient){}

    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    }

    getSporterByID(id: number):Observable<Sporter> {
        return this.http.get<Sporter>("http://localhost:8082/getSporter/" + id);
    }

    getSporters():Observable<Sporter[]>{
        return this.http.get<Sporter[]>("http://localhost:8082/allSporters")
    }

    
}