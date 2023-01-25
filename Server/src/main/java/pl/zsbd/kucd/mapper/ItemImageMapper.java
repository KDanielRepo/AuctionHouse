package pl.zsbd.kucd.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.zsbd.kucd.config.BaseMapperConfig;
import pl.zsbd.kucd.dto.ItemImageDTO;
import pl.zsbd.kucd.entity.ItemImage;
import pl.zsbd.kucd.interfaces.BaseMapper;

@Mapper(config = BaseMapperConfig.class)
public interface ItemImageMapper extends BaseMapper<ItemImage, ItemImageDTO> {
}
