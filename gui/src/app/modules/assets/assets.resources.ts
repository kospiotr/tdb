//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Assets} from "./assets.model";
import "rxjs/add/operator/map";

@Injectable()
export class AssetsResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Assets> {
    return this.http.get('/rest/assets?id=' + id)
      .map(res => <Page<Assets>>res.json())
      .map(page => <Assets[]>page.content)
      .map(records => <Assets>records[0]);
  }

  public query() {
    return this.http.get('rest/assets')
      .map(res => <Page<Assets>>res.json())
  }


}
