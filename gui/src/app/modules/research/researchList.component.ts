//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Research} from "./research.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {ResearchResources} from "./research.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-researchList',
  templateUrl: './researchList.component.html',
  styleUrls: ['./researchList.component.less']
})
export class ResearchListComponent implements OnInit {

  page: Observable<Page<Research>>;

  constructor(private http: Http, private researchResources: ResearchResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.researchResources.query();
  }

  refresh(){
    this.page= this.researchResources.query();
  }

  go(item: Research) {
    this.router.navigate(['research', item.id]);
  }

  edit(item: Research) {
    this.router.navigate(['research', item.id, 'edit']);
  }

  copy(item: Research) {
    this.router.navigate(['research', item.id, 'copy']);
  }

  trash(item: Research) {
    // this.router.navigate(['research', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['research', 'create']);
  }


}
