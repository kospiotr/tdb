//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Newsletters} from "./newsletters.model";
import "rxjs/add/operator/map";

@Injectable()
export class NewslettersResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Newsletters> {
    return this.http.get('/rest/newsletters?id=' + id)
      .map(res => <Page<Newsletters>>res.json())
      .map(page => <Newsletters[]>page.content)
      .map(records => <Newsletters>records[0]);
  }

  public query() {
    return this.http.get('rest/newsletters')
      .map(res => <Page<Newsletters>>res.json())
  }


}
