//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Users} from "./users.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {UsersResources} from "./users.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-usersList',
  templateUrl: './usersList.component.html',
  styleUrls: ['./usersList.component.less']
})
export class UsersListComponent implements OnInit {

  page: Observable<Page<Users>>;

  constructor(private http: Http, private usersResources: UsersResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.usersResources.query();
  }

  refresh(){
    this.page= this.usersResources.query();
  }

  go(item: Users) {
    this.router.navigate(['users', item.id]);
  }

  edit(item: Users) {
    this.router.navigate(['users', item.id, 'edit']);
  }

  copy(item: Users) {
    this.router.navigate(['users', item.id, 'copy']);
  }

  trash(item: Users) {
    // this.router.navigate(['users', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['users', 'create']);
  }


}
