//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {User} from "./user.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {UserResources} from "./user.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-userList',
  templateUrl: './userList.component.html',
  styleUrls: ['./userList.component.less']
})
export class UserListComponent implements OnInit {

  page: Observable<Page<User>>;

  constructor(private http: Http, private userResources: UserResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.userResources.query();
  }

  refresh(){
    this.page= this.userResources.query();
  }

  go(item: User) {
    this.router.navigate(['user', item.id]);
  }

  edit(item: User) {
    this.router.navigate(['user', item.id, 'edit']);
  }

  copy(item: User) {
    this.router.navigate(['user', item.id, 'copy']);
  }

  trash(item: User) {
    // this.router.navigate(['user', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['user', 'create']);
  }


}
