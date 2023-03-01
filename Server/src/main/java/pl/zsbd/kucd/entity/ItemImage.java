package pl.zsbd.kucd.entity;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;

import javax.persistence.*;

@Table(name = "ITEM_IMAGE")
@Entity
@Data
@SequenceGenerator(name = "SEQUENCES", sequenceName = "ITEM_IMAGE_SEQ", allocationSize = 1)
public class ItemImage extends AbstractEntity {
    @Lob
    @Column(name = "IMAGE")
    private byte[] image;
    @ManyToOne
    private Auction auction;
    @Column(name = "THUMBNAIL")
    private Boolean thumbnail;
}
