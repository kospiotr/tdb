//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Services} from "./services.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {ServicesResources} from "./services.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-servicesList',
  templateUrl: './servicesList.component.html',
  styleUrls: ['./servicesList.component.less']
})
export class ServicesListComponent implements OnInit {

  page: Observable<Page<Services>>;

  constructor(private http: Http, private servicesResources: ServicesResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.servicesResources.query();
  }

  refresh(){
    this.page= this.servicesResources.query();
  }

  go(item: Services) {
    this.router.navigate(['services', item.id]);
  }

  edit(item: Services) {
    this.router.navigate(['services', item.id, 'edit']);
  }

  copy(item: Services) {
    this.router.navigate(['services', item.id, 'copy']);
  }

  trash(item: Services) {
    // this.router.navigate(['services', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['services', 'create']);
  }


}
