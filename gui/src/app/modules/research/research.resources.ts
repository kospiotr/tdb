//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Research} from "./research.model";
import "rxjs/add/operator/map";

@Injectable()
export class ResearchResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Research> {
    return this.http.get('/rest/research?id=' + id)
      .map(res => <Page<Research>>res.json())
      .map(page => <Research[]>page.content)
      .map(records => <Research>records[0]);
  }

  public query() {
    return this.http.get('rest/research')
      .map(res => <Page<Research>>res.json())
  }


}
