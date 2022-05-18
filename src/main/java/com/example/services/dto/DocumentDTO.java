package com.example.services.dto;

public class DocumentDTO {
    private Integer id;
    private String location;
    private Integer idDocumentType;
    private Integer idUser;
    private Boolean report;

    public DocumentDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(Integer idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Boolean getReport() {
        return report;
    }
    public void setReport(Boolean report) {
        this.report = report;
    }
}
