package com.car.rental.car.rental.services.impls;

import com.car.rental.car.rental.repo.CarRepoMapper;
import com.car.rental.car.rental.repo.CarWithCategoryMapper;
import com.car.rental.car.rental.repo.repomodel.CarRepoModel;
import com.car.rental.car.rental.services.CarService;
import com.car.rental.car.rental.services.servicemodel.CarCategoryModel;
import com.car.rental.car.rental.services.servicemodel.CarModel;
import com.car.rental.car.rental.services.servicemodel.OperationModel;
import com.sun.org.omg.CORBA.OperationMode;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepoMapper carRepoMapper;

    @Autowired
    CarWithCategoryMapper carWithCategoryMapper;

    @Override
    public CarModel GetCar(String carId) {
        CarModel carModel =
                new CarModel(carWithCategoryMapper
                        .getCarWithCategoryName(Integer.parseInt(carId)));
        return carModel;
    }

    @Override
    public List<CarModel> GetCars() {
        return carWithCategoryMapper.getCarsWithCategoryName().stream().map(CarModel::new)
            .collect(Collectors.toList());
    }

    @Override
    public OperationModel NewCar(CarModel carModel, CarCategoryModel carCategory) {
        CarRepoModel carRepoModel =new CarRepoModel();
        carRepoModel.setCarname(carModel.getCarName());
        carRepoModel.setCarname(carModel.getLicenceNumber());
        carRepoModel.setCarcategory(carCategory.getCategoryId());
        int effectRow= carRepoMapper.newCar(carRepoModel);
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationMessage(effectRow>0?"New Car Add succeed":"NothingAdded");
        operationModel.setOperationResult(effectRow>0);
        return operationModel;
    }

    @Override
    public OperationModel UpdateCar(CarModel carModel) {
        CarRepoModel carRepoModel =new CarRepoModel();
        carRepoModel.setCarname(carModel.getCarName());
        carRepoModel.setCarname(carModel.getLicenceNumber());
        int effectRow= carRepoMapper.updateCar(carRepoModel);
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationMessage(effectRow>0?"Updated Car":"Nothing updated");
        operationModel.setOperationResult(effectRow>0);
        return operationModel;
    }

    @Override
    public OperationModel MoveCategory(CarModel carModel, CarCategoryModel carCategory) {
        CarRepoModel carRepoModel =new CarRepoModel();
        carRepoModel.setCarcategory(carCategory.getCategoryId());
        int effectRow= carRepoMapper.moveCategory(carRepoModel);
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationMessage(effectRow>0?"Car category moved":"Nothing moved");
        operationModel.setOperationResult(effectRow>0);
        return operationModel;
    }

    @Override
    public OperationModel DeleteCar(CarModel carModel) {
        int effectRow= carRepoMapper.removeCar(Integer.parseInt(carModel.getId()));
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationMessage(effectRow>0?"Car Deleted":"Nothing delete");
        operationModel.setOperationResult(effectRow>0);
        return operationModel;
    }

    @Override
    public OperationMode isCarAvailable(String carId, DateTime dtStart, DateTime dtEnd) {
        return null;
    }
}
