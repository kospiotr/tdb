//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Scientists} from "./scientists.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {ScientistsResources} from "./scientists.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-scientistsList',
  templateUrl: './scientistsList.component.html',
  styleUrls: ['./scientistsList.component.less']
})
export class ScientistsListComponent implements OnInit {

  page: Observable<Page<Scientists>>;

  constructor(private http: Http, private scientistsResources: ScientistsResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.scientistsResources.query();
  }

  refresh(){
    this.page= this.scientistsResources.query();
  }

  go(item: Scientists) {
    this.router.navigate(['scientists', item.id]);
  }

  edit(item: Scientists) {
    this.router.navigate(['scientists', item.id, 'edit']);
  }

  copy(item: Scientists) {
    this.router.navigate(['scientists', item.id, 'copy']);
  }

  trash(item: Scientists) {
    // this.router.navigate(['scientists', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['scientists', 'create']);
  }


}
