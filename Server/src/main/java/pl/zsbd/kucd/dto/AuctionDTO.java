package pl.zsbd.kucd.dto;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractDTO;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class AuctionDTO extends AbstractDTO {
    private Long userId;
    private String title;
    private String description;
    private List<ItemImageDTO> itemImages;
    private ZonedDateTime auctionStart = ZonedDateTime.now();
    private ZonedDateTime auctionEnd;
    private BigDecimal price;
    private Integer quantity;
    private Boolean active = Boolean.TRUE;
}
