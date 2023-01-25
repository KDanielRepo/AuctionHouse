package pl.zsbd.kucd.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pl.zsbd.kucd.config.BaseMapperConfig;
import pl.zsbd.kucd.dto.UserInfoDTO;
import pl.zsbd.kucd.entity.UserInfo;
import pl.zsbd.kucd.interfaces.BaseMapper;

@Mapper(config = BaseMapperConfig.class)
public interface UserInfoMapper extends BaseMapper<UserInfo, UserInfoDTO> {
}
