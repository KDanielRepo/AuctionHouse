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
    private String title;
    private String description;
    @OneToMany(mappedBy = "auction")
    private List<ItemImage> itemImages;
    private ZonedDateTime auctionStart;
    private ZonedDateTime auctionEnd;
    private BigDecimal price;
    private Integer quantity;
    private Boolean active;
}
