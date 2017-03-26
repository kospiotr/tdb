import {Component, OnInit} from "@angular/core";
import {Router, NavigationEnd, ActivatedRoute} from "@angular/router";
import "rxjs/add/operator/filter";
import "rxjs/add/operator/map";
import "rxjs/add/operator/mergeMap";

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.less']
})
export class LayoutComponent implements OnInit {

  title: string;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
    this.router.events.filter(event => event instanceof NavigationEnd)
      .map(() => this.activatedRoute)
      .map(route => {
        while (route.firstChild) route = route.firstChild;
        return route;
      })
      .filter(route => route.outlet === 'primary')
      .mergeMap(route => route.data)
      .subscribe((data) => {
        console.log(data);
        this.title = data != null ? data['title'] : '';
      });
  }

  ngOnInit() {

  }

}
