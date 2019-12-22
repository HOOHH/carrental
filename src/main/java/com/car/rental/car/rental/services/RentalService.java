package com.car.rental.car.rental.services;

import com.car.rental.car.rental.services.servicemodel.CarOccupiedTimeTable;

import java.util.List;

public interface RentalService {

    List<CarOccupiedTimeTable> GetCarAvaTime(String carId,String timeStampS,String timeStampE);

}
