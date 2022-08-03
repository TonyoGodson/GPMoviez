package com.godston.gpmovies.model;

public class AllCategories {

    String categoryTitle;
    Integer category;

    public AllCategories(Integer category, String categoryTitle) {
        this.categoryTitle = categoryTitle;
        this.category = category;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
