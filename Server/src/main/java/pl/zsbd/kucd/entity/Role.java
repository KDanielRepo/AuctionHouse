package pl.zsbd.kucd.entity;

import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;
import pl.zsbd.kucd.enums.Roles;

import javax.persistence.*;

@Entity
@Table
@Data
@SequenceGenerator(name = "SEQUENCES", sequenceName = "ROLE_SEQ", allocationSize = 1)
public class Role extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private Roles roles;
}
