package com.car.rental.car.rental.repo.repomodel;

import java.time.LocalDateTime;

public class CarCategoryRepoModel {

    private int id;
    private String  categoryname;
    private LocalDateTime lastupdate;

    public CarCategoryRepoModel() {
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastupdate(LocalDateTime lastupdate) {
        this.lastupdate = lastupdate;
    }

    public int getId() {
        return id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public LocalDateTime getLastupdate() {
        return lastupdate;
    }
}
