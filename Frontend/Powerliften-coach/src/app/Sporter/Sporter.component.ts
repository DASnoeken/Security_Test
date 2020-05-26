import { Component } from '@angular/core';
import { SporterService } from './Sporter.service';
import { Sporter } from './Sporter';


@Component({
    selector: 'de-sporter',
    templateUrl: 'sporter.component.html',
    providers: [SporterService]
})

export class SporterComponent{
    sporters:Sporter[] = [];
    sporter:Sporter;
    test:number = 44;

    constructor(private sporterService : SporterService){
        this.sporterService.getSporters().subscribe(x => {x.forEach(element => this.sporters.push(element))});
    }
    setSporter($event){
        this.sporterService.getSporterByID($event.target.value).subscribe(x => this.sporter = x)
    }

}