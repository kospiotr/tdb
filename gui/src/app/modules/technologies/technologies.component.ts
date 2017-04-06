//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {TechnologiesResources} from "./technologies.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Technologies} from "./technologies.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-technologies',
  templateUrl: './technologies.component.html',
  styleUrls: ['./technologies.component.less']
})
export class TechnologiesComponent implements OnInit {

  record: Observable<Technologies>;

  constructor(private route: ActivatedRoute, private technologiesResources: TechnologiesResources) {
  }

  ngOnInit() {
    // this.technologiesListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.technologiesResources.get(+params['id']));
  }


}
