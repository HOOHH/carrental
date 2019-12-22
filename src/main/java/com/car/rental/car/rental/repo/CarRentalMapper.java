package com.car.rental.car.rental.repo;

import com.car.rental.car.rental.repo.repomodel.CarOccTimeStamp;
import com.car.rental.car.rental.repo.repomodel.OccupRequestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarRentalMapper {

    @Select("    SELECT r.beginat,r.endat,c.carname,c.licencenumber FROM carrental r\n" +
            "        LEFT JOIN car c\n" +
            "        ON c.id =r.carid\n" +
            "        WHERE (r.beginat BETWEEN @start AND #{end}) OR\n" +
            "        (r.endat BETWEEN #{start} AND #{end}) OR\n" +
            "        (r.beginat > #{start} AND r.endat < #{end})\n"+
            "        c.id=#{carId}")
    List<CarOccTimeStamp> getOccTimeSpans(OccupRequestModel carReqModel);

}
