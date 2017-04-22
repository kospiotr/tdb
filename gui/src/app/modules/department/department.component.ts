//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {DepartmentResources} from "./department.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Department} from "./department.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.less']
})
export class DepartmentComponent implements OnInit {

  record: Observable<Department>;

  constructor(private route: ActivatedRoute, private departmentResources: DepartmentResources) {
  }

  ngOnInit() {
    // this.departmentListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.departmentResources.get(+params['id']));
  }


}
