//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {AssetsResources} from "./assets.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Assets} from "./assets.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-assets',
  templateUrl: './assets.component.html',
  styleUrls: ['./assets.component.less']
})
export class AssetsComponent implements OnInit {

  record: Observable<Assets>;

  constructor(private route: ActivatedRoute, private assetsResources: AssetsResources) {
  }

  ngOnInit() {
    // this.assetsListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.assetsResources.get(+params['id']));
  }


}
