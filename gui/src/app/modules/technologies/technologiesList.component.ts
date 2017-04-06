//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Technologies} from "./technologies.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {TechnologiesResources} from "./technologies.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-technologiesList',
  templateUrl: './technologiesList.component.html',
  styleUrls: ['./technologiesList.component.less']
})
export class TechnologiesListComponent implements OnInit {

  page: Observable<Page<Technologies>>;

  constructor(private http: Http, private technologiesResources: TechnologiesResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.technologiesResources.query();
  }

  refresh(){
    this.page= this.technologiesResources.query();
  }

  go(item: Technologies) {
    this.router.navigate(['technologies', item.id]);
  }

  edit(item: Technologies) {
    this.router.navigate(['technologies', item.id, 'edit']);
  }

  copy(item: Technologies) {
    this.router.navigate(['technologies', item.id, 'copy']);
  }

  trash(item: Technologies) {
    // this.router.navigate(['technologies', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['technologies', 'create']);
  }


}
