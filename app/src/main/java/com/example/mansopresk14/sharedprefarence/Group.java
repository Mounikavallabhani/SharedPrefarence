package com.example.mansopresk14.sharedprefarence;

import java.util.ArrayList;

/**
 * Created by Mansopresk14 on 3/16/2018.
 */

public class Group {
    private String Name;
    private int Image;
    private ArrayList<Child> Items;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }
}
