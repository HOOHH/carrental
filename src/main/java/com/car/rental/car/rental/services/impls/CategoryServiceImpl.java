package com.car.rental.car.rental.services.impls;

import com.car.rental.car.rental.repo.CarCategoryMapper;
import com.car.rental.car.rental.repo.repomodel.CarCategoryRepoModel;
import com.car.rental.car.rental.services.CategoryService;
import com.car.rental.car.rental.services.servicemodel.CarCategoryModel;
import com.car.rental.car.rental.services.servicemodel.OperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CarCategoryMapper categoryMapper;

    @Override
    public CarCategoryModel GetCarCategory(String categoryId) {
        return new CarCategoryModel(categoryMapper.getCategory(Integer.parseInt(categoryId)));
    }

    @Override
    public List<CarCategoryModel> GetCarCategories() {
        return categoryMapper.selectCategories().stream().map(CarCategoryModel::new).collect(Collectors.toList());
    }

    @Override
    public List<CarCategoryModel> FindCategories(String fuzzyString) {
        return  categoryMapper.findCategory(fuzzyString).stream().map(CarCategoryModel::new).collect(Collectors.toList());
    }

    @Override
    public OperationModel NewCategory(CarCategoryModel carCategory) {

        CarCategoryRepoModel carCategoryRepoModel = new CarCategoryRepoModel();
        carCategoryRepoModel.setCategoryname(carCategory.getCategoryName());
        int effectRow= categoryMapper.newCategory(carCategoryRepoModel);
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationMessage(effectRow>0? "Insert Category Succeed":"Nothing inserted");
        operationModel.setOperationResult(effectRow>0);
        return operationModel;
    }

    @Override
    public OperationModel UpdateCategory(String categoryId, CarCategoryModel carCategory) {
        CarCategoryRepoModel carCategoryRepoModel = new CarCategoryRepoModel();
        carCategoryRepoModel.setCategoryname(carCategory.getCategoryName());
        carCategoryRepoModel.setId(carCategory.getCategoryId());
        int effectRow= categoryMapper.updateCategory(carCategoryRepoModel);
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationMessage(effectRow > 0? "Update Category Succeed":"Nothing updated");
        operationModel.setOperationResult(effectRow > 0);
        return operationModel;
    }

    @Override
    public OperationModel RemoveCategory(String categoryId) {
        int effectRow = categoryMapper.removeCategory(Integer.parseInt(categoryId));
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationMessage(effectRow>0? "Remove Category Succeed":"Nothing Removed");
        operationModel.setOperationResult(effectRow>0);
        return operationModel;
    }
}
