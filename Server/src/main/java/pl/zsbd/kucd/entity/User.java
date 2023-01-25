package pl.zsbd.kucd.entity;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "SEQUENCES", sequenceName = "USER_SEQ", allocationSize = 1)
public class User extends AbstractEntity {
    private String login;
    private String password;
    @OneToOne
    private UserInfo userInfo;
    private Boolean deleted;
    private Boolean banned;
    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
