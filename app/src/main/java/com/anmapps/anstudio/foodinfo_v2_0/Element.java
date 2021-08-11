package com.anmapps.anstudio.foodinfo_v2_0;

public class Element {

    private String name;
    private int elementImg;
    private String elementDetails;


    public Element(String name, int elementImg, String elementDetails) {
        this.name = name;
        this.elementImg = elementImg;
        this.elementDetails = elementDetails;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getElementDetails() {
        return elementDetails;
    }


    public int getElementImg() {
        return elementImg;
    }

    public void setElementImg(int elementImg) {
        this.elementImg = elementImg;
    }
}
