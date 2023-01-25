package pl.zsbd.kucd.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.zsbd.kucd.config.BaseMapperConfig;
import pl.zsbd.kucd.decorators.AuctionDecorator;
import pl.zsbd.kucd.dto.AuctionDTO;
import pl.zsbd.kucd.entity.Auction;
import pl.zsbd.kucd.interfaces.BaseMapper;

import java.util.List;

@Mapper(config = BaseMapperConfig.class)
@DecoratedWith(AuctionDecorator.class)
public interface AuctionMapper extends BaseMapper<Auction, AuctionDTO> {

    @Override
    AuctionDTO toDTO(Auction entity);

    @Override
    Auction toEntity(AuctionDTO dto);

    @Override
    List<AuctionDTO> toDTOs(List<Auction> entities);

    @Override
    List<Auction> toEntities(List<AuctionDTO> dtos);
}
