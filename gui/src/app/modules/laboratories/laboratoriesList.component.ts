//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Laboratories} from "./laboratories.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {LaboratoriesResources} from "./laboratories.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-laboratoriesList',
  templateUrl: './laboratoriesList.component.html',
  styleUrls: ['./laboratoriesList.component.less']
})
export class LaboratoriesListComponent implements OnInit {

  page: Observable<Page<Laboratories>>;

  constructor(private http: Http, private laboratoriesResources: LaboratoriesResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.laboratoriesResources.query();
  }

  refresh(){
    this.page= this.laboratoriesResources.query();
  }

  go(item: Laboratories) {
    this.router.navigate(['laboratories', item.id]);
  }

  edit(item: Laboratories) {
    this.router.navigate(['laboratories', item.id, 'edit']);
  }

  copy(item: Laboratories) {
    this.router.navigate(['laboratories', item.id, 'copy']);
  }

  trash(item: Laboratories) {
    // this.router.navigate(['laboratories', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['laboratories', 'create']);
  }


}
