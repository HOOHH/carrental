package com.car.rental.car.rental.repo;

import com.car.rental.car.rental.repo.repomodel.CarRepoModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CarRepoMapper {
    @Select(value = "SELECT *  FROM car WHERE id=#{value}" )
    CarRepoModel selectCar(String id);

    @Select(value = "SELECT *  FROM car" )
    List<CarRepoMapper> selectCars();

    @Insert(value ="INSERT INTO car (carname,licencenumber,carcategory,lastupdate) VALUES (#{carname},#{licencenumber},#{carcategory},NOW())")
    int newCar(CarRepoModel carRepoModel);

    @Update(value= "UPDATE car set carname=#{carname},licencenumber=#{licencenumber},lastupdate=NOW() WHERE id=#{id}")
    int updateCar(CarRepoModel carRepoModel);

    @Delete(value="DELETE car WHERE id=#{value}")
    int removeCar(int carId);

    @Select(value="SELECT * FROM car WHERE licencenumber like '%#{value}%'")
    List<CarRepoModel> findCars(String licenceNo);

    @Update(value= "UPDATE car set carcategory=#{carcategory},lastupdate=NOW() WHERE id=#{id}")
    int moveCategory(CarRepoModel carRepoModel);
}
