package com.example.demoAPM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String aPMNumber;
    private String dateIssue;
    private String personWork;
    private String dateStartWork;
    private String dateStopWork;
    private String distance;
    private String timeWork;
    private String timeDrive;
    private String description;
    private String descriptionWorker;
    private String status;

    public ServiceCard() {

    }

    public ServiceCard(Long id, String aPMNumber, String dateIssue, String personWork, String dateStartWork, String dateStopWork, String distance, String timeWork, String timeDrive, String description, String descriptionWorker, String status) {
        this.id = id;
        this.aPMNumber = aPMNumber;
        this.dateIssue = dateIssue;
        this.personWork = personWork;
        this.dateStartWork = dateStartWork;
        this.dateStopWork = dateStopWork;
        this.distance = distance;
        this.timeWork = timeWork;
        this.timeDrive = timeDrive;
        this.description = description;
        this.descriptionWorker = descriptionWorker;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescriptionWorker() {
        return descriptionWorker;
    }

    public void setDescriptionWorker(String descriptionWorker) {
        this.descriptionWorker = descriptionWorker;
    }

    public String getaPMNumber() {
        return aPMNumber;
    }

    public void setaPMNumber(String aPMNumber) {
        this.aPMNumber = aPMNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(String dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getPersonWork() {
        return personWork;
    }

    public void setPersonWork(String personWork) {
        this.personWork = personWork;
    }

    public String getDateStartWork() {
        return dateStartWork;
    }

    public void setDateStartWork(String dateStartWork) {
        this.dateStartWork = dateStartWork;
    }

    public String getDateStopWork() {
        return dateStopWork;
    }

    public void setDateStopWork(String dateStopWork) {
        this.dateStopWork = dateStopWork;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(String timeWork) {
        this.timeWork = timeWork;
    }

    public String getTimeDrive() {
        return timeDrive;
    }

    public void setTimeDrive(String timeDrive) {
        this.timeDrive = timeDrive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
