import { Component, OnInit } from '@angular/core';
import {AuctionHouseService} from "../services/auction-house.service";

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {

  auctions: any;
  currentAuction = null;
  currentIndex = -1;

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private auctionHouseService: AuctionHouseService) { }

  ngOnInit(): void {
  }

  getRequestParams(page, pageSize): any {
      // tslint:disable-next-line:prefer-const
      let params = {};

      if (page) {
        params[`page`] = page - 1;
      }

      if (pageSize) {
        params[`size`] = pageSize;
      }

      return params;
    }

    retrieveAuctions(): void {
      const params = this.getRequestParams(this.page, this.pageSize);

      this.auctionHouseService.paginationAuctions(params)
        .subscribe(
          response => {
            const auctions = response.content;
            const totalItems = response.pageSize;
            this.auctions = auctions;
            this.count = totalItems;
            console.log(response);
          },
          error => {
            console.log(error);
          });
    }

    handlePageChange(event): void {
      this.page = event;
      this.retrieveAuctions();
    }

    handlePageSizeChange(event): void {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveAuctions();
    }

    setActiveAuction(auction, index): void {
      this.currentAuction = auction;
      this.currentIndex = index;
    }

    /*removeAllTutorials(): void {
      this.tutorialService.deleteAll()
        .subscribe(
          response => {
            console.log(response);
            this.retrieveTutorials();
          },
          error => {
            console.log(error);
          });
    }
*/
}
