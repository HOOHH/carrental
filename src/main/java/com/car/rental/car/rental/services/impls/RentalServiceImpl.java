package com.car.rental.car.rental.services.impls;

import com.car.rental.car.rental.repo.CarRentalMapper;
import com.car.rental.car.rental.repo.repomodel.OccupRequestModel;
import com.car.rental.car.rental.services.RentalService;
import com.car.rental.car.rental.services.servicemodel.CarOccupiedTimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    CarRentalMapper rentalMapper;

    @Override
    public List<CarOccupiedTimeTable> GetCarAvaTime(String carId, String timeStampS, String timeStampE) {

        OccupRequestModel req = new OccupRequestModel();
        req.setCarId(Integer.parseInt(carId));
        req.setEnd(LocalDateTime.parse(timeStampE));
        req.setStart(LocalDateTime.parse(timeStampS));

        return rentalMapper.getOccTimeSpans(req).stream().map(CarOccupiedTimeTable::new)
                .collect(Collectors.toList());
    }
}
