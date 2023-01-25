import {Component, OnInit, ViewChild} from '@angular/core';
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {AuctionOrder} from "./models/auction-order.model";
import {Cart} from "./models/cart.model";
import {AuctionHouseService} from "./services/auction-house.service";
import {Auction} from "./models/auction.model";
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector: 'app-auction-house',
  templateUrl: './auction-house.component.html',
  styleUrls: ['./auction-house.component.css']
})
export class AuctionHouseComponent implements OnInit {
    auctionOrders: AuctionOrder[] = [];
    orderFinished = false;
    auctions: Auction[] = [];
    selectedAuctionOrder: AuctionOrder;
    private shoppingCartOrders: Cart;
    productSelected: boolean = false;
    sub: Subscription;

    @ViewChild('shoppingCartC')
    shoppingCartC: ShoppingCartComponent;

    constructor(private auctionHouseService: AuctionHouseService) {
    }

    ngOnInit() {
    console.log("jestem w test");
        this.auctionOrders = [];
        this.loadAuctions();
        this.loadOrders();
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
      }

    finishOrder(orderFinished: boolean) {
        this.orderFinished = orderFinished;
    }

    getAuctionIndex(auction: Auction): number {
        return this.auctionHouseService.Cart.auctionOrder.findIndex(
            value => value.auction === auction);
    }

    isProductSelected(auction: Auction): boolean {
        return this.getAuctionIndex(auction) > -1;
    }

    loadAuctions() {
        this.auctionHouseService.getAllAuctions()
            .subscribe(
                auctions => {
                    this.auctions = auctions.content;
                    this.auctions.forEach(auction => {
                        this.auctionOrders.push(new AuctionOrder(auction, 0));
                    })
                },
            (error) => console.log(error)
        );
    }
    loadOrders() {
        this.sub = this.auctionHouseService.AuctionOrderChanged.subscribe(() => {
            this.shoppingCartOrders = this.auctionHouseService.Cart;
        });
    }
}
