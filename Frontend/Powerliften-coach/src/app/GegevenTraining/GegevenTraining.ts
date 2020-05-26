import { Oefening } from '../Oefening/oefening';


export class GegevenTraining{
    id? : number;
    oefening: Oefening;
    oefeningen: Oefening[];
    aantalReps: number;
    gewicht: number;
    tijd: Date;
}