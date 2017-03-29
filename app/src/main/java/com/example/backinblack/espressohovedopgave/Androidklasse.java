package com.example.backinblack.espressohovedopgave;

import java.io.Serializable;

/**
 * Created by backinblack on 06-01-2017.
 */
public class Androidklasse implements Serializable {

    private String Image;
    private String description;
    private String pris;
    private String mereinformation;

    public String getMereinformation() {
        return mereinformation;
    }

    public void setMereinformation(String mereinformation) {
        this.mereinformation = mereinformation;
    }

    public Androidklasse(String description, String image) {
        this.description = description;
        Image = image;

    }

    public Androidklasse() {
    }



    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }
}
