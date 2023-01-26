package pl.zsbd.kucd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "ADDRESS")
@Entity
@Data
@SequenceGenerator(name = "SEQUENCES", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
public class Address extends AbstractEntity {
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String city;
    private String zipCode;
    private String country;
    @ManyToOne
    private UserInfo userInfo;
}
