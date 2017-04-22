//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {UserResources} from "./user.resources";
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

  constructor(private route: ActivatedRoute, private userResources: UserResources) {
  }

  ngOnInit() {
    // this.userListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.userResources.get(+params['id']));
  }


}
