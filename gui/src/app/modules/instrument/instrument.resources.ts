//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Instrument} from "./instrument.model";
import "rxjs/add/operator/map";

@Injectable()
export class InstrumentResources {

constructor(private http: Http) {
}

public get(id: Number): Observable<Instrument> {
return this.http.get('/api/instrument?id=' + id)
.map(res =>
<Page<Instrument>>res.json())
.map(page => <Instrument[]>page.content)
.map(records => <Instrument>records[0]);
}

public query() {
return this.http.get('api/instrument')
.map(res =>
<Page<Instrument>>res.json())
}


}
