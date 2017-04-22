//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {DepartmentUnit} from "./departmentUnit.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {DepartmentUnitResources} from "./departmentUnit.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-departmentUnitList',
  templateUrl: './departmentUnitList.component.html',
  styleUrls: ['./departmentUnitList.component.less']
})
export class DepartmentUnitListComponent implements OnInit {

  page: Observable<Page<DepartmentUnit>>;

  constructor(private http: Http, private departmentUnitResources: DepartmentUnitResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.departmentUnitResources.query();
  }

  refresh(){
    this.page= this.departmentUnitResources.query();
  }

  go(item: DepartmentUnit) {
    this.router.navigate(['departmentUnit', item.id]);
  }

  edit(item: DepartmentUnit) {
    this.router.navigate(['departmentUnit', item.id, 'edit']);
  }

  copy(item: DepartmentUnit) {
    this.router.navigate(['departmentUnit', item.id, 'copy']);
  }

  trash(item: DepartmentUnit) {
    // this.router.navigate(['departmentUnit', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['departmentUnit', 'create']);
  }


}
