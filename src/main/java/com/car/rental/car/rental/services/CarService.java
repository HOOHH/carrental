package com.car.rental.car.rental.services;

import com.car.rental.car.rental.services.servicemodel.CarCategoryModel;
import com.car.rental.car.rental.services.servicemodel.CarModel;
import com.car.rental.car.rental.services.servicemodel.OperationModel;
import com.sun.org.omg.CORBA.OperationMode;
import org.joda.time.DateTime;

import java.util.List;

public interface CarService {

    CarModel GetCar(String carId);
    List<CarModel> GetCars();
    OperationModel NewCar(CarModel carModel,CarCategoryModel carCategory);
    OperationModel UpdateCar(CarModel carModel);
    OperationModel MoveCategory(CarModel carModel, CarCategoryModel carCategory);
    OperationModel DeleteCar(CarModel carModel);
    OperationMode isCarAvailable(String carId, DateTime dtStart, DateTime dtEnd);
}
