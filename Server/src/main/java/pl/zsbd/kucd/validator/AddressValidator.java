package pl.zsbd.kucd.validator;

import org.springframework.stereotype.Component;
import pl.zsbd.kucd.dto.AddressDTO;
import pl.zsbd.kucd.interfaces.Validator;

@Component
public class AddressValidator implements Validator<AddressDTO> {
    @Override
    public void validate(AddressDTO entity) {

    }
}
