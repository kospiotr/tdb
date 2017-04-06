//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Laboratories} from "./laboratories.model";
import "rxjs/add/operator/map";

@Injectable()
export class LaboratoriesResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Laboratories> {
    return this.http.get('/rest/laboratories?id=' + id)
      .map(res => <Page<Laboratories>>res.json())
      .map(page => <Laboratories[]>page.content)
      .map(records => <Laboratories>records[0]);
  }

  public query() {
    return this.http.get('rest/laboratories')
      .map(res => <Page<Laboratories>>res.json())
  }


}
