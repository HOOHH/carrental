package com.car.rental.car.rental.repo.repomodel;

import java.time.LocalDateTime;

public class OccupRequestModel {
    private LocalDateTime start;
    private LocalDateTime end;
    private int carId;

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }
}
