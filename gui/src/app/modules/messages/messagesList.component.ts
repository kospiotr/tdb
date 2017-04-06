//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Messages} from "./messages.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {MessagesResources} from "./messages.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-messagesList',
  templateUrl: './messagesList.component.html',
  styleUrls: ['./messagesList.component.less']
})
export class MessagesListComponent implements OnInit {

  page: Observable<Page<Messages>>;

  constructor(private http: Http, private messagesResources: MessagesResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.messagesResources.query();
  }

  refresh(){
    this.page= this.messagesResources.query();
  }

  go(item: Messages) {
    this.router.navigate(['messages', item.id]);
  }

  edit(item: Messages) {
    this.router.navigate(['messages', item.id, 'edit']);
  }

  copy(item: Messages) {
    this.router.navigate(['messages', item.id, 'copy']);
  }

  trash(item: Messages) {
    // this.router.navigate(['messages', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['messages', 'create']);
  }


}
