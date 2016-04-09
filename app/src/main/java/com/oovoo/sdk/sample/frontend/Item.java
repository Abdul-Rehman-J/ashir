package com.oovoo.sdk.sample.frontend;

import java.util.ArrayList;

/**
 * Created by tb_laota on 9/21/2015.
 */
public class Item {
    public String title,image,year;
    public double rate;
    private ArrayList<String> genre;


    public Item() {
    }
    public Item(String title,String year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }


}
