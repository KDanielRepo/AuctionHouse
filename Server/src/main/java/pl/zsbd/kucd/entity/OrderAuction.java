package pl.zsbd.kucd.entity;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ORDER_AUCTION")
@SequenceGenerator(name = "SEQUENCES", sequenceName = "ORDER_AUCTION_SEQ", allocationSize = 1)
public class OrderAuction extends AbstractEntity {
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "AUCTION_ID")
    private Long auctionId;
}
