import {Auction} from "./auction.model";

export class AuctionOrder {
    auction: Auction;
    quantity: number;

    constructor(auction: Auction, quantity: number) {
        this.auction = auction;
        this.quantity = quantity;
    }
}
