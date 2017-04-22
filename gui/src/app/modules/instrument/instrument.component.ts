//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {InstrumentResources} from "./instrument.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Instrument} from "./instrument.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-instrument',
  templateUrl: './instrument.component.html',
  styleUrls: ['./instrument.component.less']
})
export class InstrumentComponent implements OnInit {

  record: Observable<Instrument>;

  constructor(private route: ActivatedRoute, private instrumentResources: InstrumentResources) {
  }

  ngOnInit() {
    // this.instrumentListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.instrumentResources.get(+params['id']));
  }


}
