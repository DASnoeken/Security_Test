import { Component } from '@angular/core';
import { Oefening } from './oefening';
import { OefeningService } from './oefening.service';
import { $ } from 'protractor';
import { format } from 'path';

@Component({
    selector: 'de-oefening',
    templateUrl: 'oefening.component.html',
    providers: [OefeningService]
})
export class OefeningComponent{
    deFoto : File;
    id:number;
    oefeningPH:Oefening = new Oefening();
    oefeningen:Oefening[] = [];
    getOefeningClicked:Boolean=false;
    fileSelected:Boolean=false;
    oefeningNaam:string;
    constructor(private oefeningService : OefeningService){}
    isNumber(value: string | number): boolean{
       return ((value != null) &&
               (value !== '') &&
               !isNaN(Number(value.toString())));
    }
    getOefeningById(){
        if(!this.isNumber(this.id)){
            console.log('Dit is geen getal!');
            this.oefeningPH.id=this.id;
            this.oefeningPH.naam='ONGELDIG';
            this.oefeningen.push(this.oefeningPH);
        }else{
            this.oefeningen=[];
            this.oefeningService.getOefeningByID(this.id).subscribe(oefening => this.oefeningen.push(oefening));
            this.getOefeningClicked=true;
        }
        
    }
    getOefeningByNaam(){
        this.oefeningen=[];
        this.oefeningService.getOefeningByNaam(this.oefeningNaam).subscribe(oefening => this.oefeningen.push(oefening))
    }
    onFileSelected($event){
        this.deFoto = <File>$event.target.files[0];
        this.fileSelected=true;
        console.log(this.deFoto);
    }
    onUpload(){
        console.log("onUpload");
        console.log(this.deFoto.name);
        this.oefeningService.verstuurFoto(this.oefeningNaam,this.deFoto).subscribe(oefening => console.log(oefening));
        alert(''+this.deFoto.name+' is toegevoegd!')
    }
    setOefeningID($event){
        this.id = $event.target.value;
    }
    getAllOefeningen(){
        this.oefeningen = [];
        this.oefeningService.getAllOefeningen().subscribe(oefening => {for(let i = 0;i<oefening.length;i++){this.oefeningen.push(oefening[i]);}});
        console.log(this.oefeningen);
    }
    schoonScherm(){
        this.oefeningen = [];
    }
}