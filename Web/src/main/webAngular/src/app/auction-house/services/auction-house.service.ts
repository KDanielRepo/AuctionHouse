import {AuctionOrder} from "../models/auction-order.model";
import {Subject} from "rxjs/internal/Subject";
import {Cart} from "../models/cart.model";
import {HttpClient} from '@angular/common/http';
import {Injectable} from "@angular/core";
import { from, Observable } from 'rxjs';
import {Auction} from "../models/auction.model";
import {Auctions} from "../models/auctions.model";
import { catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class AuctionHouseService {
    private auctionsUrl = "/api/auctions";
    private ordersUrl = "/api/orders";
    private createAuctionUrl = "/api/createAuction";
    private canCreateAuctionUrl = "/api/create";

    private auctionOrder: AuctionOrder;
    private cart: Cart = new Cart();

    private auctionOrderSubject = new Subject();
    private cartSubject = new Subject();
    private totalSubject = new Subject();

    private total: number;

    AuctionOrderChanged = this.auctionOrderSubject.asObservable();
    CartChanged = this.cartSubject.asObservable();
    TotalChanged = this.totalSubject.asObservable();

    constructor(private http: HttpClient) {
    }

    paginationAuctions(params): Observable<Auctions> {
        return this.http.get<Auctions>(this.auctionsUrl, {params});
    }

    getAllAuctions(): Observable<Auctions> {
        return this.http.get<Auctions>(this.auctionsUrl);
    }

    getAuction(auctionId: number): Observable<Auction> {
      return this.http.get<Auction>(this.auctionsUrl+"/"+auctionId);
    }

    createAuction(auction: Auction){
      return this.http.post(this.createAuctionUrl, auction);
    }

    canCreateAuction(){
    console.log("can create");
      return this.http.get(this.canCreateAuctionUrl);
    }

    saveCart(cart: Cart) {
        return this.http.post(this.ordersUrl, cart);
    }

    set SelectedAuctionOrder(value: AuctionOrder) {
        this.auctionOrder = value;
        this.auctionOrderSubject.next(value);
    }

    get SelectedAuctionOrder() {
        return this.auctionOrder;
    }

    set Cart(value: Cart) {
        this.cart = value;
        this.cartSubject.next(value);
    }

    get Cart() {
        return this.cart;
    }

    get Total() {
        return this.total;
    }

    set Total(value: number) {
        this.total = value;
        this.totalSubject.next(value);
    }
}
