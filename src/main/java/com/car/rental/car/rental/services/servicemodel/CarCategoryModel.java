package com.car.rental.car.rental.services.servicemodel;

import com.car.rental.car.rental.apiresponse.models.CarCategory;
import com.car.rental.car.rental.repo.repomodel.CarCategoryRepoModel;

public class CarCategoryModel {
    private int categoryId;
    private String categoryName;
    private String categoryImage;

    public  CarCategoryModel(CarCategoryRepoModel categoryModel){
        this.categoryId = categoryModel.getId();
        this.categoryName = categoryModel.getCategoryname();
    }

    public  CarCategoryModel(CarCategory carCategory){
        this.categoryName = carCategory.getCategoryName();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
