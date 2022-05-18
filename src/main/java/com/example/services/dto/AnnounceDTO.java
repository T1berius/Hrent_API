package com.example.services.dto;

import javax.persistence.Column;
import java.sql.Time;
import java.util.Date;

public class AnnounceDTO {

    private Integer id;
    private String title;
    private String description;
    private String postalCode;
    private String city;
    private String country;
    private Double price;
    private Double caution;
    private Integer capacity;
    private Date startDate;
    private Date endDate;
    private Integer idTypeLogement;
    private Boolean isIdCardRequired;
    private Boolean isSmokingAllowed;
    private Boolean isPetsAllowed;
    private Boolean isPassportRequired;
    private Boolean isProofOfAddressRequired;
    private Time arrivalTime;
    private Time departureTime;
    private String telephoneNumber;
    private Date creationDate;
    private String LocationPrimaryPicture;
    private String LocationSecondaryPicture;
    private String LocationThirdPicture;
    private String LocationFourthPicture;
    private String LocationFifthPicture;
    private Integer idUser;


    public AnnounceDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCaution() {
        return caution;
    }

    public void setCaution(Double caution) {
        this.caution = caution;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIdTypeLogement() {
        return idTypeLogement;
    }

    public void setIdTypeLogement(Integer idTypeLogement) {
        this.idTypeLogement = idTypeLogement;
    }

    public Boolean getIsIdCardRequired() {
        return isIdCardRequired;
    }

    public void setIsIdCardRequired(Boolean isIdCardRequired) {
        this.isIdCardRequired = isIdCardRequired;
    }

    public Boolean getIsSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setIsSmokingAllowed(Boolean isSmokingAllowed) {
        this.isSmokingAllowed = isSmokingAllowed;
    }

    public Boolean getIsPetsAllowed() {
        return isPetsAllowed;
    }

    public void setIsPetsAllowed(Boolean isPetsAllowed) {
        this.isPetsAllowed = isPetsAllowed;
    }

    public Boolean getIsPassportRequired() {
        return isPassportRequired;
    }

    public void setIsPassportRequired(Boolean isPassportRequired) {
        this.isPassportRequired = isPassportRequired;
    }

    public Boolean getIsProofOfAddressRequired() {
        return isProofOfAddressRequired;
    }

    public void setIsProofOfAddressRequired(Boolean isProofOfAddressRequired) {
        this.isProofOfAddressRequired = isProofOfAddressRequired;
    }

    public Boolean getIdCardRequired() {
        return isIdCardRequired;
    }

    public void setIdCardRequired(Boolean idCardRequired) {
        isIdCardRequired = idCardRequired;
    }

    public Boolean getSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setSmokingAllowed(Boolean smokingAllowed) {
        isSmokingAllowed = smokingAllowed;
    }

    public Boolean getPetsAllowed() {
        return isPetsAllowed;
    }

    public void setPetsAllowed(Boolean petsAllowed) {
        isPetsAllowed = petsAllowed;
    }

    public Boolean getPassportRequired() {
        return isPassportRequired;
    }

    public void setPassportRequired(Boolean passportRequired) {
        isPassportRequired = passportRequired;
    }

    public Boolean getProofOfAddressRequired() {
        return isProofOfAddressRequired;
    }

    public void setProofOfAddressRequired(Boolean proofOfAddressRequired) {
        isProofOfAddressRequired = proofOfAddressRequired;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getCreatedDate() {
        return creationDate;
    }

    public String getLocationPrimaryPicture() {
        return LocationPrimaryPicture;
    }

    public void setLocationPrimaryPicture(String locationPrimaryPicture) {
        LocationPrimaryPicture = locationPrimaryPicture;
    }

    public String getLocationSecondaryPicture() {
        return LocationSecondaryPicture;
    }

    public void setLocationSecondaryPicture(String locationSecondaryPicture) {
        LocationSecondaryPicture = locationSecondaryPicture;
    }

    public String getLocationThirdPicture() {
        return LocationThirdPicture;
    }

    public void setLocationThirdPicture(String locationThirdPicture) {
        LocationThirdPicture = locationThirdPicture;
    }

    public String getLocationFourthPicture() {
        return LocationFourthPicture;
    }

    public void setLocationFourthPicture(String locationFourthPicture) {
        LocationFourthPicture = locationFourthPicture;
    }

    public String getLocationFifthPicture() {
        return LocationFifthPicture;
    }

    public void setLocationFifthPicture(String locationFifthPicture) {
        LocationFifthPicture = locationFifthPicture;
    }

    public void getCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}