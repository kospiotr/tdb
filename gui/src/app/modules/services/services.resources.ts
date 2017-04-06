//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Services} from "./services.model";
import "rxjs/add/operator/map";

@Injectable()
export class ServicesResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Services> {
    return this.http.get('/rest/services?id=' + id)
      .map(res => <Page<Services>>res.json())
      .map(page => <Services[]>page.content)
      .map(records => <Services>records[0]);
  }

  public query() {
    return this.http.get('rest/services')
      .map(res => <Page<Services>>res.json())
  }


}
