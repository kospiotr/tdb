//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Technologies} from "./technologies.model";
import "rxjs/add/operator/map";

@Injectable()
export class TechnologiesResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Technologies> {
    return this.http.get('/rest/technologies?id=' + id)
      .map(res => <Page<Technologies>>res.json())
      .map(page => <Technologies[]>page.content)
      .map(records => <Technologies>records[0]);
  }

  public query() {
    return this.http.get('rest/technologies')
      .map(res => <Page<Technologies>>res.json())
  }


}
