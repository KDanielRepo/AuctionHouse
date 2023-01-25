package pl.zsbd.kucd.dto;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractDTO;

import java.util.List;

@Data
public class UserInfoDTO extends AbstractDTO {
    private String name;
    private String surname;
    private String nickname;
    private Integer phoneNumber;
    private List<AddressDTO> addresses;
    private String email;
}
