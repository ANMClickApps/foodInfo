package com.anmapps.anstudio.foodinfo_v2_0;

import java.util.ArrayList;

public class Categoriya {

    private String name;
    private int categImg;
    ArrayList<Element>elementsList=new ArrayList<>();



    public Categoriya(String name, int categImg, ArrayList<Element> elementsList) {
        super();
        this.name = name;
        this.categImg = categImg;
        this.elementsList = elementsList;
    }


    public String getName() {
        return name;
    }

    public int getCategImg() {
        return categImg;
    }

    public ArrayList<Element> getElementsList() {
        return elementsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategImg(int categImg) {
        this.categImg = categImg;
    }

    public void setElementsList(ArrayList<Element> elementsList) {
        this.elementsList = elementsList;
    }
}
