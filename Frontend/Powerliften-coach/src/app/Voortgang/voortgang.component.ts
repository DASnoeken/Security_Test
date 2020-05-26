import { Component } from '@angular/core';
import { Voortgang } from './voortgang';
import { VoortgangService } from './voortgang.service';
import { $ } from 'protractor';

@Component({
    selector: 'de-voortgang',
    templateUrl: 'voortgang.component.html',
    providers: [VoortgangService]
})
export class VoortgangComponent{
    voortgang1 : Voortgang = new Voortgang();
    voortgangen : Voortgang[] = [];
    feedback : string = '';
    id:number = 0;
    voortgangenIDCheck : Voortgang[] = [];
    veranderFeedback($event){
        this.feedback = $event.target.value;
    }
    veranderID($event){
        this.id = $event.target.value;
    }
    constructor(private voortgangService : VoortgangService){   //Dependency injection -- synoniem met @Autowired
        this.voortgang1.gebruikteGewicht = 36;
        console.log("constructor VoortgangComponent");
    }
    vulVoortgangen(){
        this.voortgangen = [];
        this.voortgangService.getAllVoortgang().subscribe(voortgang => this.voortgangen.push(voortgang));
        console.log(this.voortgangen);
    }
    setFeedback(feedback:string,id:number){
        this.voortgangService.geefFeedback(feedback,id).subscribe(feedback => console.log(feedback));
        this.vulVoortgangen();
    }
    checkID(id:number){
        this.voortgangenIDCheck = [];
        this.voortgangService.bekijkID(id).subscribe(voortgang => this.voortgangenIDCheck.push(voortgang));
        console.log(this.voortgangenIDCheck);
    }
    schoonScherm(){
        this.voortgangen=[];
        this.voortgangenIDCheck=[];
    }
}
