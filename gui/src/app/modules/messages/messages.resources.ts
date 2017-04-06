//
// created by: Piotr Kosmowski
// Template pack-custom:gui/src/app/modules/entities/entity.resources.ts.e.vm
//
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import {Page} from "../../shared/page";
import {Messages} from "./messages.model";
import "rxjs/add/operator/map";

@Injectable()
export class MessagesResources {

  constructor(private http: Http) {
  }

  public get(id: Number): Observable<Messages> {
    return this.http.get('/rest/messages?id=' + id)
      .map(res => <Page<Messages>>res.json())
      .map(page => <Messages[]>page.content)
      .map(records => <Messages>records[0]);
  }

  public query() {
    return this.http.get('rest/messages')
      .map(res => <Page<Messages>>res.json())
  }


}
