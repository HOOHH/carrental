package com.car.rental.car.rental.apiresponse.models;

import com.car.rental.car.rental.services.servicemodel.CarOccupiedTimeTable;

import java.util.List;

public class CarAvailable {
    public boolean isAvailable(){
        return  timeTables==null || timeTables.size() ==0;
    }

    private  List<CarOccupiedTimeTable> timeTables;
    public CarAvailable(List<CarOccupiedTimeTable> timeTables){
        this.timeTables = timeTables;
    }
}
