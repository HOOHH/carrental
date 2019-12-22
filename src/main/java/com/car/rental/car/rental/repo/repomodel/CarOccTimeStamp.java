package com.car.rental.car.rental.repo.repomodel;

import java.time.LocalDateTime;

public class CarOccTimeStamp {
    LocalDateTime beginat;
    LocalDateTime endat;
    String carname;
    String licencenumber;

    public String getCarname() {
        return carname;
    }

    public String getLicencenumber() {
        return licencenumber;
    }

    public LocalDateTime getBeginat() {
        return beginat;
    }

    public LocalDateTime getEndat() {
        return endat;
    }
}


