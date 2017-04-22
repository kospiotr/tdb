//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {UserGroupResources} from "./userGroup.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {UserGroup} from "./userGroup.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-userGroup',
  templateUrl: './userGroup.component.html',
  styleUrls: ['./userGroup.component.less']
})
export class UserGroupComponent implements OnInit {

  record: Observable<UserGroup>;

  constructor(private route: ActivatedRoute, private userGroupResources: UserGroupResources) {
  }

  ngOnInit() {
    // this.userGroupListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.userGroupResources.get(+params['id']));
  }


}
