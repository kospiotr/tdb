//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Permission} from "./permission.model";
import "rxjs/add/operator/map";

@Injectable()
export class PermissionResources {

constructor(private http: Http) {
}

public get(id: Number): Observable<Permission> {
return this.http.get('/api/permission?id=' + id)
.map(res =>
<Page<Permission>>res.json())
.map(page => <Permission[]>page.content)
.map(records => <Permission>records[0]);
}

public query() {
return this.http.get('api/permission')
.map(res =>
<Page<Permission>>res.json())
}


}
