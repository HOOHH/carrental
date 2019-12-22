package com.car.rental.car.rental.repo;

import com.car.rental.car.rental.repo.repomodel.CarWithCategoryRepoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarWithCategoryMapper {

    @Select("SELECT c.id,c.carname,c.licencenumber,cat.id as categoryId,cat.categoryname  from car c LEFT JOIN carcategory cat on c.carcategory = cat.id  WHERE c.id=#{value}")
    CarWithCategoryRepoModel getCarWithCategoryName(int carId);

    @Select("SELECT c.id,c.carname,c.licencenumber,cat.id as categoryId,cat.categoryname  from car c LEFT JOIN carcategory cat on c.carcategory = cat.id ")
    List<CarWithCategoryRepoModel> getCarsWithCategoryName();
}
