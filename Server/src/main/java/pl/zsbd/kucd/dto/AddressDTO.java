package pl.zsbd.kucd.dto;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractDTO;

@Data
public class AddressDTO extends AbstractDTO {
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String city;
    private String zipCode;
    private String country;
}
