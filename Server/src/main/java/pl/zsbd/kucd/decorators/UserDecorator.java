package pl.zsbd.kucd.decorators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.zsbd.kucd.dto.UserDTO;
import pl.zsbd.kucd.entity.User;
import pl.zsbd.kucd.entity.UserInfo;
import pl.zsbd.kucd.mapper.UserMapper;
import pl.zsbd.kucd.entity.Role;
import pl.zsbd.kucd.enums.Roles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Objects;

public abstract class UserDecorator implements UserMapper {

    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDTO toDTO(User entity) {
        UserDTO dto = delegate.toDTO(entity);
        dto.setEmail(entity.getUserInfo().getEmail());
        dto.setPhoneNumber(entity.getUserInfo().getPhoneNumber());
        return dto;
    }

    @Override
    public User toEntity(UserDTO dto) {
        User user = delegate.toEntity(dto);
        if(Objects.isNull(user.getId())){
            UserInfo userInfo = new UserInfo();
            user.setUserInfo(userInfo);
        }
        //todo Poprawić
        Role role = new Role();
        role.setRoles(Roles.ROLE_USER);
        user.setRoles(Collections.singleton(role));
        user.getUserInfo().setEmail(dto.getEmail());
        user.getUserInfo().setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
