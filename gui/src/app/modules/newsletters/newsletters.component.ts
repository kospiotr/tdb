//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {NewslettersResources} from "./newsletters.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Newsletters} from "./newsletters.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-newsletters',
  templateUrl: './newsletters.component.html',
  styleUrls: ['./newsletters.component.less']
})
export class NewslettersComponent implements OnInit {

  record: Observable<Newsletters>;

  constructor(private route: ActivatedRoute, private newslettersResources: NewslettersResources) {
  }

  ngOnInit() {
    // this.newslettersListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.newslettersResources.get(+params['id']));
  }


}
