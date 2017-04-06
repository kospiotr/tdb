//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Newsletters} from "./newsletters.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {NewslettersResources} from "./newsletters.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-newslettersList',
  templateUrl: './newslettersList.component.html',
  styleUrls: ['./newslettersList.component.less']
})
export class NewslettersListComponent implements OnInit {

  page: Observable<Page<Newsletters>>;

  constructor(private http: Http, private newslettersResources: NewslettersResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.newslettersResources.query();
  }

  refresh(){
    this.page= this.newslettersResources.query();
  }

  go(item: Newsletters) {
    this.router.navigate(['newsletters', item.id]);
  }

  edit(item: Newsletters) {
    this.router.navigate(['newsletters', item.id, 'edit']);
  }

  copy(item: Newsletters) {
    this.router.navigate(['newsletters', item.id, 'copy']);
  }

  trash(item: Newsletters) {
    // this.router.navigate(['newsletters', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['newsletters', 'create']);
  }


}
