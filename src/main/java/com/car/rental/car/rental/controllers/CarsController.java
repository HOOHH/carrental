package com.car.rental.car.rental.controllers;

import com.car.rental.car.rental.apiresponse.ApiOperation;
import com.car.rental.car.rental.apiresponse.ApiResponse;
import com.car.rental.car.rental.apiresponse.models.Car;
import com.car.rental.car.rental.apiresponse.models.CarAvailable;
import com.car.rental.car.rental.services.CarService;
import com.car.rental.car.rental.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
public class CarsController extends CarRentalControllerBase {

    @Autowired
    CarService carServiceImpl;

    @Autowired
    RentalService rentalService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ApiResponse<List<Car>> listCars(){
        return  getSuccessResponse(
        carServiceImpl.GetCars().stream().map(x->{
           Car c=new Car();
           c.setName(x.getCarName());
           c.setCategory(x.getCategoryName());
           c.setLicenceNumber(x.getLicenceNumber());
           c.setId(x.getId());
           return  c;
        }).collect(Collectors.toList()));

    }

    @RequestMapping(value = "{car-id}",method = RequestMethod.GET)
    public  ApiResponse<Car> getCarsDetail(@PathVariable("car-id") String carId){
        return  null;
    }

    @RequestMapping(value="{car-id}",method = RequestMethod.PUT)
    public  ApiResponse<ApiOperation> updateCar(
            @PathVariable("car-id")String carId,
            @RequestBody Car carInformation) {
        return  null;
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    public ApiResponse<ApiOperation> newCar(
            @RequestBody Car car){
        return  null;
    }

    @RequestMapping(value="{car-id}",method = RequestMethod.DELETE)
    public ApiResponse<ApiOperation> removeCar(@PathVariable("car-id")String carId){
        return null;
    }


    @RequestMapping(value = "available",method = RequestMethod.GET)
    public ApiResponse<List<Car>> getCarsAvailableBetween(
            @RequestParam(name ="start") LocalDateTime start,
            @RequestParam(name ="end") LocalDateTime end){

        return  null;
    }

    @RequestMapping(value="{car-id}/available", method = RequestMethod.GET)
    public ApiResponse<CarAvailable> getCarsAvailable(
            @PathVariable("car-id") String carId,
            @RequestParam(name ="start")String start,
            @RequestParam(name ="end") String end){
        CarAvailable carAvailable = new CarAvailable(rentalService.GetCarAvaTime(carId,start,end));
        return  getSuccessResponse(carAvailable);
    }


}
