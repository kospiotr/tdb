//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {ResearchResources} from "./research.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Research} from "./research.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-research',
  templateUrl: './research.component.html',
  styleUrls: ['./research.component.less']
})
export class ResearchComponent implements OnInit {

  record: Observable<Research>;

  constructor(private route: ActivatedRoute, private researchResources: ResearchResources) {
  }

  ngOnInit() {
    // this.researchListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.researchResources.get(+params['id']));
  }


}
