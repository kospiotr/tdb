import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.less']
})
export class MenuComponent implements OnInit {
  routes: RouteLink[] = [];

  ngOnInit(): void {
  }

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
    for (var i = 0; i < this.router.config.length; i++) {
      var config = this.router.config[i];
      var data = config.data as Object;

      if (data != null && data.hasOwnProperty('title') && data.hasOwnProperty('listable') && data['listable'] as boolean) {
        this.routes.push(new RouteLink(config.path, data['title'] as string))
      }
    }
  }
}

export class RouteLink {
  constructor(private path: string, private name: string) {
  }
}
