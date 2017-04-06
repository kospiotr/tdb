//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {ScientistsResources} from "./scientists.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Scientists} from "./scientists.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-scientists',
  templateUrl: './scientists.component.html',
  styleUrls: ['./scientists.component.less']
})
export class ScientistsComponent implements OnInit {

  record: Observable<Scientists>;

  constructor(private route: ActivatedRoute, private scientistsResources: ScientistsResources) {
  }

  ngOnInit() {
    // this.scientistsListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.scientistsResources.get(+params['id']));
  }


}
