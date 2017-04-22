//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {UserGroup} from "./userGroup.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {UserGroupResources} from "./userGroup.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-userGroupList',
  templateUrl: './userGroupList.component.html',
  styleUrls: ['./userGroupList.component.less']
})
export class UserGroupListComponent implements OnInit {

  page: Observable<Page<UserGroup>>;

  constructor(private http: Http, private userGroupResources: UserGroupResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.userGroupResources.query();
  }

  refresh(){
    this.page= this.userGroupResources.query();
  }

  go(item: UserGroup) {
    this.router.navigate(['userGroup', item.id]);
  }

  edit(item: UserGroup) {
    this.router.navigate(['userGroup', item.id, 'edit']);
  }

  copy(item: UserGroup) {
    this.router.navigate(['userGroup', item.id, 'copy']);
  }

  trash(item: UserGroup) {
    // this.router.navigate(['userGroup', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['userGroup', 'create']);
  }


}
