package pl.zsbd.kucd.entity;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;
import pl.zsbd.kucd.enums.OrderStatus;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "ORDER")
@SequenceGenerator(name = "SEQUENCES", sequenceName = "ORDER_SEQ", allocationSize = 1)
public class Order extends AbstractEntity {
    @ManyToMany
    @JoinTable(name = "ORDER_AUCTION",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUCTION_ID"))
    private List<Auction> items;
    private ZonedDateTime creationDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
