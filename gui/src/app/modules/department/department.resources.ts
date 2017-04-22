//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Department} from "./department.model";
import "rxjs/add/operator/map";

@Injectable()
export class DepartmentResources {

constructor(private http: Http) {
}

public get(id: Number): Observable<Department> {
return this.http.get('/api/department?id=' + id)
.map(res =>
<Page<Department>>res.json())
.map(page => <Department[]>page.content)
.map(records => <Department>records[0]);
}

public query() {
return this.http.get('api/department')
.map(res =>
<Page<Department>>res.json())
}


}
