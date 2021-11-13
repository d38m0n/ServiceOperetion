package com.example.demoAPM.model;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String startAssembly;
    private String deadlineInstalled;
    private String location;
    private String numberFacility;
    private String zipCode;
    private String city;
    private String street;
    private String columnID;
    private String ipCCTV;
    private String cctv;
    private String cctvReady;
    private String contactPerson;
    private String phoneNumber;
    private String voivodeship;
    private String machineWidth;
    private String shape;
    private String typeModule;
    private String msisdn;
    private String instStatus;
    private String apmNumber;
    private String firstEntry;
    private String InstallDate;
    private String installTeam;
    private String installStatusWork;
    private String powerReady;

    private String workOrderDate;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getPowerReady() {
        return powerReady;
    }

    public void setPowerReady(String powerReady) {
        this.powerReady = powerReady;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String designation) {
        this.location = designation;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String example2) {
        this.zipCode = example2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String example3) {
        this.city = example3;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String example4) {
        this.street = example4;
    }

    public String getApmNumber() {
        return apmNumber;
    }

    public void setApmNumber(String example5) {
        this.apmNumber = example5;
    }

    public String getInstallStatusWork() {
        return installStatusWork;
    }

    public void setInstallStatusWork(String example6) {
        this.installStatusWork = example6;
    }

    public String getWorkOrderDate() {
        return workOrderDate;
    }

    public void setWorkOrderDate(String example7) {
        this.workOrderDate = example7;
    }

    public String getColumnID() {
        return columnID;
    }

    public void setColumnID(String example8) {
        this.columnID = example8;
    }

    public String getInstStatus() {
        return instStatus;
    }

    public void setInstStatus(String example9) {
        this.instStatus = example9;
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

    public String getNumberFacility() {
        return numberFacility;
    }

    public void setNumberFacility(String numberFacility) {
        this.numberFacility = numberFacility;
    }

    public String getIpCCTV() {
        return ipCCTV;
    }

    public void setIpCCTV(String ipCCTV) {
        this.ipCCTV = ipCCTV;
    }

    public String getCctv() {
        return cctv;
    }

    public void setCctv(String cctv) {
        this.cctv = cctv;
    }

    public String getCctvReady() {
        return cctvReady;
    }

    public void setCctvReady(String cctvReady) {
        this.cctvReady = cctvReady;
    }

    public String getMachineWidth() {
        return machineWidth;
    }

    public void setMachineWidth(String machineWidth) {
        this.machineWidth = machineWidth;
    }

    public String getTypeModule() {
        return typeModule;
    }

    public void setTypeModule(String typeModule) {
        this.typeModule = typeModule;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getStartAssembly() {
        return startAssembly;
    }

    public void setStartAssembly(String startAssembly) {
        this.startAssembly = startAssembly;
    }

    public String getDeadlineInstalled() {
        return deadlineInstalled;
    }

    public void setDeadlineInstalled(String deadlineInstalled) {
        this.deadlineInstalled = deadlineInstalled;
    }

    public String getFirstEntry() {
        return firstEntry;
    }

    public void setFirstEntry(String firstEntry) {
        this.firstEntry = firstEntry;
    }

    public String getInstallDate() {
        return InstallDate;
    }

    public void setInstallDate(String installDate) {
        InstallDate = installDate;
    }

    public String getInstallTeam() {
        return installTeam;
    }

    public void setInstallTeam(String installTeam) {
        this.installTeam = installTeam;
    }

    public Item() {
    }

    public Item(Long id, String startAssembly, String deadlineInstalled, String location, String numberFacility, String zipCode, String city, String street, String columnID, String ipCCTV, String cctv, String cctvReady, String contactPerson, String phoneNumber, String voivodeship, String machineWidth, String shape, String typeModule, String msisdn, String instStatus, String apmNumber, String firstEntry, String installDate, String installTeam, String installStatusWork, String powerReady, String workOrderDate) {
        this.id = id;
        this.startAssembly = startAssembly;
        this.deadlineInstalled = deadlineInstalled;
        this.location = location;
        this.numberFacility = numberFacility;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.columnID = columnID;
        this.ipCCTV = ipCCTV;
        this.cctv = cctv;
        this.cctvReady = cctvReady;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.voivodeship = voivodeship;
        this.machineWidth = machineWidth;
        this.shape = shape;
        this.typeModule = typeModule;
        this.msisdn = msisdn;
        this.instStatus = instStatus;
        this.apmNumber = apmNumber;
        this.firstEntry = firstEntry;
        InstallDate = installDate;
        this.installTeam = installTeam;
        this.installStatusWork = installStatusWork;
        this.powerReady = powerReady;
        this.workOrderDate = workOrderDate;
    }

    public Item(Long id, String voivodeship, String location, String city, String zipCode, String street, String apmNumber, String installStatusWork, String workOrderDate, String columnID, String instStatus) {
        this.id = id;
        this.voivodeship = voivodeship;
        this.location = location;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.apmNumber = apmNumber;
        this.installStatusWork = installStatusWork;
        this.workOrderDate = workOrderDate;
        this.columnID = columnID;
        this.instStatus = instStatus;
    }
}


