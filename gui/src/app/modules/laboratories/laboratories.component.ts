//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {LaboratoriesResources} from "./laboratories.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Laboratories} from "./laboratories.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-laboratories',
  templateUrl: './laboratories.component.html',
  styleUrls: ['./laboratories.component.less']
})
export class LaboratoriesComponent implements OnInit {

  record: Observable<Laboratories>;

  constructor(private route: ActivatedRoute, private laboratoriesResources: LaboratoriesResources) {
  }

  ngOnInit() {
    // this.laboratoriesListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.laboratoriesResources.get(+params['id']));
  }


}
