package com.car.rental.car.rental.repo.repomodel;

import java.time.LocalDateTime;

public class CarRepoModel {
    private  String id;
    private String carname;
    private LocalDateTime lastupdate;
    private String licencenumber;
    private int carcategory;

    public String getId() {
        return id;
    }

    public String getCarName() {
        return carname;
    }

    public LocalDateTime getLastUpdate() {
        return lastupdate;
    }

    public String getCarLicenceNumber() {
        return licencenumber;
    }

    public int getCategoryId() {
        return carcategory;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }
    public void setLicencenumber(String licencenumber) {
        this.licencenumber = licencenumber;
    }

    public void setCarcategory(int carcategory) {
        this.carcategory = carcategory;
    }
}
