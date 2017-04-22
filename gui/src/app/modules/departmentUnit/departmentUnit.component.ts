//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {DepartmentUnitResources} from "./departmentUnit.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {DepartmentUnit} from "./departmentUnit.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-departmentUnit',
  templateUrl: './departmentUnit.component.html',
  styleUrls: ['./departmentUnit.component.less']
})
export class DepartmentUnitComponent implements OnInit {

  record: Observable<DepartmentUnit>;

  constructor(private route: ActivatedRoute, private departmentUnitResources: DepartmentUnitResources) {
  }

  ngOnInit() {
    // this.departmentUnitListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.departmentUnitResources.get(+params['id']));
  }


}
