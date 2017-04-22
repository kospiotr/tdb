//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {DepartmentUnit} from "./departmentUnit.model";
import "rxjs/add/operator/map";

@Injectable()
export class DepartmentUnitResources {

constructor(private http: Http) {
}

public get(id: Number): Observable<DepartmentUnit> {
return this.http.get('/api/departmentUnit?id=' + id)
.map(res =>
<Page<DepartmentUnit>>res.json())
.map(page => <DepartmentUnit[]>page.content)
.map(records => <DepartmentUnit>records[0]);
}

public query() {
return this.http.get('api/departmentUnit')
.map(res =>
<Page<DepartmentUnit>>res.json())
}


}
