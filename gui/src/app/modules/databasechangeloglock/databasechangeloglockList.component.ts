//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Databasechangeloglock} from "./databasechangeloglock.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {DatabasechangeloglockResources} from "./databasechangeloglock.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-databasechangeloglockList',
  templateUrl: './databasechangeloglockList.component.html',
  styleUrls: ['./databasechangeloglockList.component.less']
})
export class DatabasechangeloglockListComponent implements OnInit {

  page: Observable<Page<Databasechangeloglock>>;

  constructor(private http: Http, private databasechangeloglockResources: DatabasechangeloglockResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.databasechangeloglockResources.query();
  }

  refresh(){
    this.page= this.databasechangeloglockResources.query();
  }

  go(item: Databasechangeloglock) {
    this.router.navigate(['databasechangeloglock', item.id]);
  }

  edit(item: Databasechangeloglock) {
    this.router.navigate(['databasechangeloglock', item.id, 'edit']);
  }

  copy(item: Databasechangeloglock) {
    this.router.navigate(['databasechangeloglock', item.id, 'copy']);
  }

  trash(item: Databasechangeloglock) {
    // this.router.navigate(['databasechangeloglock', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['databasechangeloglock', 'create']);
  }


}
