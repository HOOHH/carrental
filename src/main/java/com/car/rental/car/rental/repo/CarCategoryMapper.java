package com.car.rental.car.rental.repo;

import com.car.rental.car.rental.repo.repomodel.CarCategoryRepoModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CarCategoryMapper {
    @Select(value = "SELECT * FROM carcategory")
    List<CarCategoryRepoModel> selectCategories();
    @Select(value = "SELECT * FROM carcategory WHERE id=#{value}")
    CarCategoryRepoModel getCategory(int categoryId);
    @Insert(value = "INSERT INTO carcategory(categoryname,lastupdate) VALUES(#{categoryname},NOW())")
    int newCategory(CarCategoryRepoModel carCategory);
    @Update(value = "UPDATE carcategory SET categoryname=#{categoryname},lastupdate=NOW() WHERE id=#{id}")
    int updateCategory(CarCategoryRepoModel carCategory);
    @Select(value = "SELECT COUNT(1) from carcategory")
    int countCategory();
    @Select(value = "SELECT * FROM carcategory WHERE categoryname like '%#{value}%'")
    List<CarCategoryRepoModel> findCategory(String findString);
    @Delete(value = "DELETE FROM carcategory WHERE id=#{value}")
    int removeCategory(int categoryId);



}
