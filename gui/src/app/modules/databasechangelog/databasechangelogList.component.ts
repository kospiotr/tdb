//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Databasechangelog} from "./databasechangelog.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {DatabasechangelogResources} from "./databasechangelog.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-databasechangelogList',
  templateUrl: './databasechangelogList.component.html',
  styleUrls: ['./databasechangelogList.component.less']
})
export class DatabasechangelogListComponent implements OnInit {

  page: Observable<Page<Databasechangelog>>;

  constructor(private http: Http, private databasechangelogResources: DatabasechangelogResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.databasechangelogResources.query();
  }

  refresh(){
    this.page= this.databasechangelogResources.query();
  }

  go(item: Databasechangelog) {
    this.router.navigate(['databasechangelog', item.id]);
  }

  edit(item: Databasechangelog) {
    this.router.navigate(['databasechangelog', item.id, 'edit']);
  }

  copy(item: Databasechangelog) {
    this.router.navigate(['databasechangelog', item.id, 'copy']);
  }

  trash(item: Databasechangelog) {
    // this.router.navigate(['databasechangelog', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['databasechangelog', 'create']);
  }


}
