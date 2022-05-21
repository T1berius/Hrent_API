package com.example.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Date;

@Entity
@Table
public class Announce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String title;

    @Column
    @Length(max = 3000)
    private String description;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private Double price;

    @Column
    private Double caution;

    @Column
    private Integer capacity;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Integer idTypeLogement;

    @Column
    private Boolean isIdCardRequired;

    @Column
    private Boolean isSmokingAllowed;

    @Column
    private Boolean isPetsAllowed;

    @Column
    private Boolean isPassportRequired;

    @Column
    private Boolean isProofOfAddressRequired;

    @Column
    private Time arrivalTime;

    @Column
    private Time departureTime;

    @Column
    private String telephoneNumber;

    @Column
    private Date creationDate;

    @Column
    private String LocationPrimaryPicture;

    @Column
    private String LocationSecondaryPicture;

    @Column
    private String LocationThirdPicture;

    @Column
    private String LocationFourthPicture;

    @Column
    private String LocationFifthPicture;

    @Column
    private Integer idUser;

    public Announce() {
    }

    public Announce(Integer id, String title, String description, String postalCode, String city, Double price, Double caution, Integer capacity, Date startDate, Date endDate, Integer idTypeLogement, Boolean isIdCardRequired, Boolean isSmokingAllowed, Boolean isPetsAllowed, Boolean isPassportRequired, Boolean isProofOfAddressRequired, Time arrivalTime, Time departureTime, String telephoneNumber, Date creationDate, String locationPrimaryPicture, String locationSecondaryPicture, String locationThirdPicture, String locationFourthPicture, String locationFifthPicture, Integer idUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postalCode = postalCode;
        this.city = city;
        this.price = price;
        this.caution = caution;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idTypeLogement = idTypeLogement;
        this.isIdCardRequired = isIdCardRequired;
        this.isSmokingAllowed = isSmokingAllowed;
        this.isPetsAllowed = isPetsAllowed;
        this.isPassportRequired = isPassportRequired;
        this.isProofOfAddressRequired = isProofOfAddressRequired;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.telephoneNumber = telephoneNumber;
        this.creationDate = creationDate;
        this.LocationPrimaryPicture = locationPrimaryPicture;
        this.LocationSecondaryPicture = locationSecondaryPicture;
        this.LocationThirdPicture = locationThirdPicture;
        this.LocationFourthPicture = locationFourthPicture;
        this.LocationFifthPicture = locationFifthPicture;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public Double getPrice() {
        return price;
    }

    public Double getCaution() {
        return caution;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Integer getIdTypeLogement() {
        return idTypeLogement;
    }

    public Boolean getIsIdCardRequired() {
        return isIdCardRequired;
    }

    public Boolean getIsSmokingAllowed() {
        return isSmokingAllowed;
    }

    public Boolean getIsPetsAllowed() {
        return isPetsAllowed;
    }

    public Boolean getIsPassportRequired() {
        return isPassportRequired;
    }

    public Boolean getIsProofOfAddressRequired() {
        return isProofOfAddressRequired;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getLocationPrimaryPicture() {
        return LocationPrimaryPicture;
    }

    public String getLocationSecondaryPicture() {
        return LocationSecondaryPicture;
    }

    public String getLocationThirdPicture() {
        return LocationThirdPicture;
    }

    public String getLocationFourthPicture() {
        return LocationFourthPicture;
    }

    public String getLocationFifthPicture() {
        return LocationFifthPicture;
    }

    public void getIdUser(Integer id) {
        this.idUser = id;
    }

}
