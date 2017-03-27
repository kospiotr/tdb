import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {User} from "./user.model";
import "rxjs/add/operator/map";

@Injectable()
export class UsersDao {

  constructor(private http: Http) {
  }

  get(id: Number): Observable<User> {
    return this.http.get('/rest/user?id=' + id)
      .map(res => <Page<User>>res.json())
      .map(page => <User[]>page.content)
      .map(users => <User>users[0]);
  }

  queryUsers() {
    return this.http.get('rest/user')
      .map(res => <Page<User>>res.json())
  }


}
