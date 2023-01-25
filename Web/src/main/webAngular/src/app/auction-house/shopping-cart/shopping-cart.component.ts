import {Component, EventEmitter, OnDestroy, OnInit, Output} from '@angular/core';
import {Cart} from "../models/cart.model";
import {AuctionOrder} from "../models/auction-order.model";
import {AuctionHouseService} from "../services/auction-house.service";
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
    orderFinished: boolean;
    cart: Cart;
    total: number;
    sub: Subscription;

    @Output() onOrderFinished: EventEmitter<boolean>;

    constructor(private auctionHouseService: AuctionHouseService) {
        this.total = 0;
        this.orderFinished = false;
        this.onOrderFinished = new EventEmitter<boolean>();
    }

    ngOnInit() {
        this.cart = new Cart();
        //this.loadCart();
        //this.loadTotal();
    }

    private calculateTotal(items: AuctionOrder[]): number {
        let sum = 0;
        items.forEach(value => {
            sum += (value.auction.price * value.quantity);
        });
        return sum;
    }


    finishOrder() {
        this.orderFinished = true;
        this.auctionHouseService.Total = this.total;
        this.onOrderFinished.emit(this.orderFinished);
    }

    reset() {
        this.orderFinished = false;
        this.cart = new Cart();
        this.cart.auctionOrder = []
        //this.loadTotal();
        this.total = 0;
    }

}
