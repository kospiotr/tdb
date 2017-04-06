//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {UsersResources} from "./users.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Users} from "./users.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.less']
})
export class UsersComponent implements OnInit {

  record: Observable<Users>;

  constructor(private route: ActivatedRoute, private usersResources: UsersResources) {
  }

  ngOnInit() {
    // this.usersListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.usersResources.get(+params['id']));
  }


}
