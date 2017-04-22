//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Department} from "./department.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {DepartmentResources} from "./department.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-departmentList',
  templateUrl: './departmentList.component.html',
  styleUrls: ['./departmentList.component.less']
})
export class DepartmentListComponent implements OnInit {

  page: Observable<Page<Department>>;

  constructor(private http: Http, private departmentResources: DepartmentResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.departmentResources.query();
  }

  refresh(){
    this.page= this.departmentResources.query();
  }

  go(item: Department) {
    this.router.navigate(['department', item.id]);
  }

  edit(item: Department) {
    this.router.navigate(['department', item.id, 'edit']);
  }

  copy(item: Department) {
    this.router.navigate(['department', item.id, 'copy']);
  }

  trash(item: Department) {
    // this.router.navigate(['department', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['department', 'create']);
  }


}
