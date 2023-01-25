import {Auction} from "./auction.model";
export class Auctions {
  content: Auction[];
  pageNumber: number;
  pageSize: number;
  constructor(content: Auction[], pageNumber: number, pageSize: number) {
      this.content = content;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
  }
}
