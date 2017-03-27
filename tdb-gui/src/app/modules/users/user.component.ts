import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {UsersDao} from "./user.dao";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {User} from "./user.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.less']
})
export class UserComponent implements OnInit {

  record: Observable<User>;

  constructor(private route: ActivatedRoute, private usersDao: UsersDao) {
  }

  ngOnInit() {
    // this.usersDao.
    this.record = this.route.params
      .switchMap((params: Params) => this.usersDao.get(+params['id']));
  }


}
