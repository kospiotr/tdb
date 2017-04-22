//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Permission} from "./permission.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {PermissionResources} from "./permission.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-permissionList',
  templateUrl: './permissionList.component.html',
  styleUrls: ['./permissionList.component.less']
})
export class PermissionListComponent implements OnInit {

  page: Observable<Page<Permission>>;

  constructor(private http: Http, private permissionResources: PermissionResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.permissionResources.query();
  }

  refresh(){
    this.page= this.permissionResources.query();
  }

  go(item: Permission) {
    this.router.navigate(['permission', item.id]);
  }

  edit(item: Permission) {
    this.router.navigate(['permission', item.id, 'edit']);
  }

  copy(item: Permission) {
    this.router.navigate(['permission', item.id, 'copy']);
  }

  trash(item: Permission) {
    // this.router.navigate(['permission', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['permission', 'create']);
  }


}
