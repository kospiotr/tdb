//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entityList.component.ts.e.vm
//
import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {Instrument} from "./instrument.model";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {InstrumentResources} from "./instrument.resources";
import {Page} from "../../shared/page";
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-instrumentList',
  templateUrl: './instrumentList.component.html',
  styleUrls: ['./instrumentList.component.less']
})
export class InstrumentListComponent implements OnInit {

  page: Observable<Page<Instrument>>;

  constructor(private http: Http, private instrumentResources: InstrumentResources, private router: Router) {
  }

  ngOnInit() {
    this.page= this.instrumentResources.query();
  }

  refresh(){
    this.page= this.instrumentResources.query();
  }

  go(item: Instrument) {
    this.router.navigate(['instrument', item.id]);
  }

  edit(item: Instrument) {
    this.router.navigate(['instrument', item.id, 'edit']);
  }

  copy(item: Instrument) {
    this.router.navigate(['instrument', item.id, 'copy']);
  }

  trash(item: Instrument) {
    // this.router.navigate(['instrument', 'create']);
    console.log('trash');
  }

  create() {
    this.router.navigate(['instrument', 'create']);
  }


}
