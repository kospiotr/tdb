import {Component, Input, OnInit} from "@angular/core";
import {Page} from "../page";


@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.less']
})
export class PaginationComponent implements OnInit {

  @Input()
  page: Page<any>;

  constructor() {
  }

  ngOnInit() {
  }

  getCurrent(): Number {
    return this.page.number.valueOf() + 1;
  }

  hasPrevious(): boolean {
    return this.getCurrent() > 1;
  }

  hasNext(): boolean {
    return this.getCurrent() < this.getTotalPages();
  }

  getTotalPages(): Number {
    return this.page.totalPages.valueOf();
  }
}
