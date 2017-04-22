//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {UserGroup} from "./userGroup.model";
import "rxjs/add/operator/map";

@Injectable()
export class UserGroupResources {

constructor(private http: Http) {
}

public get(id: Number): Observable<UserGroup> {
return this.http.get('/api/userGroup?id=' + id)
.map(res =>
<Page<UserGroup>>res.json())
.map(page => <UserGroup[]>page.content)
.map(records => <UserGroup>records[0]);
}

public query() {
return this.http.get('api/userGroup')
.map(res =>
<Page<UserGroup>>res.json())
}


}
