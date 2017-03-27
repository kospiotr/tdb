import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {User} from "./user.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {UsersDao} from "./user.dao";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.less']
})
export class UsersComponent implements OnInit {

  page: Observable<Page<User>>;

  constructor(private http: Http, private usersDao: UsersDao, private router: Router) {
  }

  ngOnInit() {
    this.page= this.usersDao.queryUsers();
  }

  refresh(){
    this.page= this.usersDao.queryUsers();
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
