//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Databasechangeloglock} from "./databasechangeloglock.model";
import "rxjs/add/operator/map";

@Injectable()
export class DatabasechangeloglockResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Databasechangeloglock> {
    return this.http.get('/rest/databasechangeloglock?id=' + id)
      .map(res => <Page<Databasechangeloglock>>res.json())
      .map(page => <Databasechangeloglock[]>page.content)
      .map(records => <Databasechangeloglock>records[0]);
  }

  public query() {
    return this.http.get('rest/databasechangeloglock')
      .map(res => <Page<Databasechangeloglock>>res.json())
  }


}
