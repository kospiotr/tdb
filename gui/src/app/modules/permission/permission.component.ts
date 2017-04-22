//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {PermissionResources} from "./permission.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Permission} from "./permission.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-permission',
  templateUrl: './permission.component.html',
  styleUrls: ['./permission.component.less']
})
export class PermissionComponent implements OnInit {

  record: Observable<Permission>;

  constructor(private route: ActivatedRoute, private permissionResources: PermissionResources) {
  }

  ngOnInit() {
    // this.permissionListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.permissionResources.get(+params['id']));
  }


}
