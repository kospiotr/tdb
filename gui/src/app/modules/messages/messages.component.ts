//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import 'rxjs/add/operator/switchMap';
import {MessagesResources} from "./messages.resources";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Page} from "../../shared/page";
import {Messages} from "./messages.model";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.less']
})
export class MessagesComponent implements OnInit {

  record: Observable<Messages>;

  constructor(private route: ActivatedRoute, private messagesResources: MessagesResources) {
  }

  ngOnInit() {
    // this.messagesListResources.
    this.record = this.route.params
      .switchMap((params: Params) => this.messagesResources.get(+params['id']));
  }


}
