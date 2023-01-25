package pl.zsbd.kucd.dto;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractDTO;

@Data
public class ItemImageDTO extends AbstractDTO {
    private byte[] image;
    private Boolean thumbnail;
}
