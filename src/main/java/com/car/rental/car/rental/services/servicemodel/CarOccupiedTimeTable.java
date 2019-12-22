package com.car.rental.car.rental.services.servicemodel;

import com.car.rental.car.rental.repo.repomodel.CarOccTimeStamp;
import java.time.LocalDateTime;

public class CarOccupiedTimeTable {
    private LocalDateTime start ;
    private  LocalDateTime end;
    private  String carName;
    private  String carLicence;

    public CarOccupiedTimeTable(CarOccTimeStamp carOccTimeStamp){
        this.start= carOccTimeStamp.getBeginat();
        this.end = carOccTimeStamp.getEndat();
        this.carLicence = carOccTimeStamp.getLicencenumber();
        this.carName=  carOccTimeStamp.getCarname();
    }

    public String getCarName() {
        return carName;
    }

    public String getCarLicence() {
        return carLicence;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public LocalDateTime getStart() {
        return start;
    }
}
