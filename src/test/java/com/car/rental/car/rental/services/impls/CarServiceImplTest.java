package com.car.rental.car.rental.services.impls;


import com.car.rental.car.rental.repo.CarRepoMapper;
import com.car.rental.car.rental.repo.repomodel.CarRepoModel;
import com.car.rental.car.rental.services.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;


///DEMO unit -test because of timing issue.
class CarServiceImplTest {

    private CarService carService;
    private CarRepoMapper carRepoMapper;

    public  CarServiceImplTest() throws Exception {
        carService = new CarServiceImpl();
        carRepoMapper = Mockito.mock(CarRepoMapper.class);
        CarRepoModel carRepoModel= new CarRepoModel();
        carRepoModel.setCarname("aaa");
        carRepoModel.setLicencenumber("bbb");
        Mockito.when(carRepoMapper.selectCar("123")).thenReturn(carRepoModel);
        Field f= carService.getClass().getField("carWithCategoryMapper");
        f.setAccessible(true);
        f.set(carService,carRepoMapper);
    }

    @Test
    void getCar() {

    }

    @Test
    void getCars() {
    }

    @Test
    void newCar() {
    }

    @Test
    void updateCar() {
    }

    @Test
    void moveCategory() {
    }

    @Test
    void deleteCar() {
    }
}