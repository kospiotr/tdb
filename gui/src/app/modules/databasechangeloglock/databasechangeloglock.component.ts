//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {DatabasechangeloglockResources} from "./databasechangeloglock.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Databasechangeloglock} from "./databasechangeloglock.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-databasechangeloglock',
  templateUrl: './databasechangeloglock.component.html',
  styleUrls: ['./databasechangeloglock.component.less']
})
export class DatabasechangeloglockComponent implements OnInit {

  record: Observable<Databasechangeloglock>;

  constructor(private route: ActivatedRoute, private databasechangeloglockResources: DatabasechangeloglockResources) {
  }

  ngOnInit() {
    // this.databasechangeloglockListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.databasechangeloglockResources.get(+params['id']));
  }


}
