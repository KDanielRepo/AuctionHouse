package pl.zsbd.kucd.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.zsbd.kucd.config.BaseMapperConfig;
import pl.zsbd.kucd.decorators.UserDecorator;
import pl.zsbd.kucd.dto.UserDTO;
import pl.zsbd.kucd.entity.User;
import pl.zsbd.kucd.interfaces.BaseMapper;

@Mapper(config = BaseMapperConfig.class)
@DecoratedWith(UserDecorator.class)
public interface UserMapper extends BaseMapper<User, UserDTO> {
    @Override
    UserDTO toDTO(User entity);

    @Override
    User toEntity(UserDTO dto);
}
