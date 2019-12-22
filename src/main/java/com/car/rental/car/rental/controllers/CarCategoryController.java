package com.car.rental.car.rental.controllers;


import com.car.rental.car.rental.apiresponse.ApiOperation;
import com.car.rental.car.rental.apiresponse.ApiResponse;
import com.car.rental.car.rental.apiresponse.models.CarCategory;
import com.car.rental.car.rental.services.CategoryService;
import com.car.rental.car.rental.services.servicemodel.CarCategoryModel;
import com.car.rental.car.rental.services.servicemodel.OperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car-categories")
public class CarCategoryController extends CarRentalControllerBase {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ApiResponse<List<CarCategory>> listCategory(){

        return getSuccessResponse(categoryService.GetCarCategories().stream().map(x->{
            CarCategory carCategory=  new CarCategory();
            carCategory.setCategoryId((new Integer( x.getCategoryId())).toString());
            carCategory.setCategoryImage(x.getCategoryImage());
            carCategory.setCategoryName(x.getCategoryName());
            return  carCategory;
        }).collect(Collectors.toList()));
    }

    @RequestMapping(value = "{category-id}",method = RequestMethod.GET)
    public  ApiResponse<CarCategory> getCategory(@PathVariable("category-id") String id){
        CarCategoryModel serviceModel= categoryService.GetCarCategory(id);
        CarCategory carCategory = new CarCategory();
        carCategory.setCategoryName(serviceModel.getCategoryName());
        carCategory.setCategoryImage("NOT FOR NOW");
        carCategory.setCategoryId((new Integer(serviceModel.getCategoryId())).toString());
        return  getSuccessResponse(carCategory);
    }

    @RequestMapping(value="{category-id}",method = RequestMethod.PUT)
    public  ApiResponse<ApiOperation> updateCarCategory(
            @PathVariable("category-id")String categoryId,
            @RequestBody CarCategory carCategoryDetail) {
        CarCategoryModel carCategoryModel = new CarCategoryModel(carCategoryDetail);
        OperationModel om= categoryService.UpdateCategory(categoryId,carCategoryModel);
        ApiOperation apiOperation = new ApiOperation();
        apiOperation.setMessage(om.getOperationMessage());
        apiOperation.setOperationName("Update");
        return  getSuccessResponse(apiOperation);

    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    public ApiResponse<ApiOperation> newCarCategory(
            @RequestBody CarCategory carCategoryDetail){
        return  null;
    }
}
