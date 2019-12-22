package com.car.rental.car.rental.services;

import com.car.rental.car.rental.services.servicemodel.CarCategoryModel;
import com.car.rental.car.rental.services.servicemodel.OperationModel;

import java.util.List;

public interface CategoryService {

    CarCategoryModel GetCarCategory(String categoryId);
    List<CarCategoryModel> GetCarCategories();
    List<CarCategoryModel> FindCategories(String fuzzyString);
    OperationModel NewCategory(CarCategoryModel carCategory);
    OperationModel UpdateCategory(String categoryId,CarCategoryModel carCategory);
    OperationModel RemoveCategory(String categoryId);

}
