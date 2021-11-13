package com.example.demoAPM.response;

import org.springframework.http.HttpStatus;

public class ResponseMessage {

    private String message;
    private String fileDownloadUri;
    private HttpStatus httpStatus;


    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, String fileDownloadUri) {
        this.message = message;
        this.fileDownloadUri = fileDownloadUri;
    }

    public ResponseMessage(String message, HttpStatus status) {
        this.message = message;
        this.httpStatus =status;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}