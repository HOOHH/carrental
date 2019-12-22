package com.car.rental.car.rental.services.servicemodel;

import com.car.rental.car.rental.repo.repomodel.CarRepoModel;
import com.car.rental.car.rental.repo.repomodel.CarWithCategoryRepoModel;

public class CarModel {

    private  String id;
    private String carName;
    private String licenceNumber;
    private int categoryId;
    private String categoryName;

    public CarModel(CarWithCategoryRepoModel carWithCategoryRepoModel){
        this.id = carWithCategoryRepoModel.getId();
        this.carName = carWithCategoryRepoModel.getCarname();
        this.licenceNumber = carWithCategoryRepoModel.getLicencenumber();
        this.categoryName = carWithCategoryRepoModel.getCategoryname();
        this.categoryId = carWithCategoryRepoModel.getCatId();
    }



    public String getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public String getCarName() {
        return carName;
    }
}
