//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {DatabasechangelogResources} from "./databasechangelog.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Databasechangelog} from "./databasechangelog.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-databasechangelog',
  templateUrl: './databasechangelog.component.html',
  styleUrls: ['./databasechangelog.component.less']
})
export class DatabasechangelogComponent implements OnInit {

  record: Observable<Databasechangelog>;

  constructor(private route: ActivatedRoute, private databasechangelogResources: DatabasechangelogResources) {
  }

  ngOnInit() {
    // this.databasechangelogListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.databasechangelogResources.get(+params['id']));
  }


}
