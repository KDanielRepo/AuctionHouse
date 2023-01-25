import { Component } from '@angular/core';
import { AuctionHouseService } from './auction-house/services/auction-house.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [AuctionHouseService]
})
export class AppComponent {
  title = 'webAngular';
}
