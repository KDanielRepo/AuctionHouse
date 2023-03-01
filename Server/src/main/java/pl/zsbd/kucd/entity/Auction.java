package pl.zsbd.kucd.entity;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;
import pl.zsbd.kucd.abstracts.AbstractVersionedEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "AUCTION")
@SequenceGenerator(name = "SEQUENCES", sequenceName = "AUCTION_SEQ", allocationSize = 1)
public class Auction extends AbstractEntity {
    @ManyToOne
    private User user;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "auction")
    private List<ItemImage> itemImages;
    @Column(name = "AUCTION_START")
    private ZonedDateTime auctionStart;
    @Column(name = "AUCTION_END")
    private ZonedDateTime auctionEnd;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "ACTIVE")
    private Boolean active;
}
