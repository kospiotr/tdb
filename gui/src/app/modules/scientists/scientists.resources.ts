//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Scientists} from "./scientists.model";
import "rxjs/add/operator/map";

@Injectable()
export class ScientistsResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Scientists> {
    return this.http.get('/rest/scientists?id=' + id)
      .map(res => <Page<Scientists>>res.json())
      .map(page => <Scientists[]>page.content)
      .map(records => <Scientists>records[0]);
  }

  public query() {
    return this.http.get('rest/scientists')
      .map(res => <Page<Scientists>>res.json())
  }


}
