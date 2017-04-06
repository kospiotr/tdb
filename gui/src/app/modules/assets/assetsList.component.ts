//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Assets} from "./assets.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {AssetsResources} from "./assets.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-assetsList',
  templateUrl: './assetsList.component.html',
  styleUrls: ['./assetsList.component.less']
})
export class AssetsListComponent implements OnInit {

  page: Observable<Page<Assets>>;

  constructor(private http: Http, private assetsResources: AssetsResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.assetsResources.query();
  }

  refresh(){
    this.page= this.assetsResources.query();
  }

  go(item: Assets) {
    this.router.navigate(['assets', item.id]);
  }

  edit(item: Assets) {
    this.router.navigate(['assets', item.id, 'edit']);
  }

  copy(item: Assets) {
    this.router.navigate(['assets', item.id, 'copy']);
  }

  trash(item: Assets) {
    // this.router.navigate(['assets', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['assets', 'create']);
  }


}
