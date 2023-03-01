package pl.zsbd.kucd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USER_INFO")
@SequenceGenerator(name = "SEQUENCES", sequenceName = "USER_INFO_SEQ", allocationSize = 1)
public class UserInfo extends AbstractEntity {
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "PHONE_NUMBER")
    private Integer phoneNumber;
    @OneToMany(mappedBy = "userInfo")
    private List<Address> addresses;
    @Column(name = "EMAIL")
    private String email;
}
