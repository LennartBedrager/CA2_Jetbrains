package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String additionalInfo;
    // @JoinColumn(name="ADDRESS_ZIPCODES")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CityInfo city;

    public Address() {
    }

    public Address(String street, String additionalInfo, CityInfo city) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.city = city;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     *
     * @param additionalInfo additionalInfo consists of things such as building
     * number and floor.
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public CityInfo getCity() {
        return city;
    }

    /**
     *
     * @param city This inserts a CityInfo object to track which city we are in.
     */
    public void setCity(CityInfo city) {
        this.city = city;
    }

}
