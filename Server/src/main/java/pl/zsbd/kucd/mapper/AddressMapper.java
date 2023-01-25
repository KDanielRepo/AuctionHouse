package pl.zsbd.kucd.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.zsbd.kucd.config.BaseMapperConfig;
import pl.zsbd.kucd.dto.AddressDTO;
import pl.zsbd.kucd.entity.Address;
import pl.zsbd.kucd.interfaces.BaseMapper;

@Mapper(config = BaseMapperConfig.class)
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {
}
