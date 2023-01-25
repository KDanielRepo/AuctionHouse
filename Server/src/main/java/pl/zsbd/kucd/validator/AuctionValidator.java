package pl.zsbd.kucd.validator;

import org.springframework.stereotype.Component;
import pl.zsbd.kucd.dto.AuctionDTO;
import pl.zsbd.kucd.interfaces.Validator;

@Component
public class AuctionValidator implements Validator<AuctionDTO> {

    @Override
    public void validate(AuctionDTO dto) {

    }
}
