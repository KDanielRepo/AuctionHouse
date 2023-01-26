package pl.zsbd.kucd.dto;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractDTO;

@Data
public class UserDTO extends AbstractDTO {
    private String login;
    private String password;
    private Long userInfoId;
    private String email;
    private Integer phoneNumber;
    private Boolean deleted = Boolean.FALSE;
    private Boolean banned = Boolean.FALSE;
}
