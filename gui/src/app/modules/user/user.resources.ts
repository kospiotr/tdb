//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {User} from "./user.model";
import "rxjs/add/operator/map";

@Injectable()
export class UserResources {

constructor(private http: Http) {
}

public get(id: Number): Observable<User> {
return this.http.get('/api/user?id=' + id)
.map(res =>
<Page<User>>res.json())
.map(page => <User[]>page.content)
.map(records => <User>records[0]);
}

public query() {
return this.http.get('api/user')
.map(res =>
<Page<User>>res.json())
}


}
