/*
package pl.zsbd.kucd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_ROLE")
@SequenceGenerator(name = "SEQUENCES", sequenceName = "USER_ROLE_SEQ", allocationSize = 1)
public class UserRole extends AbstractEntity {
    @ManyToOne
    private Role role;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;
}
*/
