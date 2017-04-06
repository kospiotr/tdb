//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Users} from "./users.model";
import "rxjs/add/operator/map";

@Injectable()
export class UsersResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Users> {
    return this.http.get('/rest/users?id=' + id)
      .map(res => <Page<Users>>res.json())
      .map(page => <Users[]>page.content)
      .map(records => <Users>records[0]);
  }

  public query() {
    return this.http.get('rest/users')
      .map(res => <Page<Users>>res.json())
  }


}
