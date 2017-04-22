//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Databasechangelog} from "./databasechangelog.model";
import "rxjs/add/operator/map";

@Injectable()
export class DatabasechangelogResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Databasechangelog> {
    return this.http.get('/rest/databasechangelog?id=' + id)
      .map(res => <Page<Databasechangelog>>res.json())
      .map(page => <Databasechangelog[]>page.content)
      .map(records => <Databasechangelog>records[0]);
  }

  public query() {
    return this.http.get('rest/databasechangelog')
      .map(res => <Page<Databasechangelog>>res.json())
  }


}
