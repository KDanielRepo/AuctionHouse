package pl.zsbd.kucd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.zsbd.kucd.abstracts.AbstractEntity;

import javax.persistence.*;

@Table(name = "ADDRESS")
@Entity
@Data
@SequenceGenerator(name = "SEQUENCES", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
public class Address extends AbstractEntity {
    @Column(name = "STREET")
    private String street;
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @Column(name = "APARTMENT_NUMBER")
    private String apartmentNumber;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "COUNTRY")
    private String country;
    @ManyToOne
    private UserInfo userInfo;
}
