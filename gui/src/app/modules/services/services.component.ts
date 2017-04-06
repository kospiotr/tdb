//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {ServicesResources} from "./services.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Services} from "./services.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.less']
})
export class ServicesComponent implements OnInit {

  record: Observable<Services>;

  constructor(private route: ActivatedRoute, private servicesResources: ServicesResources) {
  }

  ngOnInit() {
    // this.servicesListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.servicesResources.get(+params['id']));
  }


}
