package com.example.demoAPM.dto;

public class ItemDTO {
    private Long id;

    private String voivodeship;
    private String location;
    private String city;
    private String zipCode;
    private String street;
    private String apmNumber;
    private String contactPerson;
    private String phoneNumber;
    private String columnID;
    private String instStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApmNumber() {
        return apmNumber;
    }

    public void setApmNumber(String apmNumber) {
        this.apmNumber = apmNumber;
    }



    public String getColumnID() {
        return columnID;
    }

    public void setColumnID(String columnID) {
        this.columnID = columnID;
    }

    public String getInstStatus() {
        return instStatus;
    }

    public void setInstStatus(String instStatus) {
        this.instStatus = instStatus;
    }

    public ItemDTO() {

    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ItemDTO(Long id, String voivodeship, String location, String city, String zipCode, String street, String apmNumber, String contactPerson, String phoneNumber, String columnID, String instStatus) {
        this.id = id;
        this.voivodeship = voivodeship;
        this.location = location;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.apmNumber = apmNumber;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.columnID = columnID;
        this.instStatus = instStatus;
    }
}
