package pl.zsbd.kucd.validator;

import org.springframework.stereotype.Component;
import pl.zsbd.kucd.dto.UserDTO;
import pl.zsbd.kucd.interfaces.Validator;

@Component
public class UserValidator implements Validator<UserDTO> {
    @Override
    public void validate(UserDTO entity) {

    }
}
