package com.car.rental.car.rental.repo.repomodel;

public class CarWithCategoryRepoModel {
    private  String id;
    private String carname;
    private String licencenumber;
    private String categoryname;
    private int catId;

    public String getLicencenumber() {
        return licencenumber;
    }

    public String getCarname() {
        return carname;
    }

    public String getId() {
        return id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public int getCatId() {
        return catId;
    }
}
