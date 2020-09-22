package com.example.prototype;

public class targets {

    public String target_title;
    public int target_image;
    public String[] target_subjetcs;

    public  targets()
    {

    }

    public targets(String target_title, int target_image, String[] target_subjetcs) {
        this.target_title = target_title;
        this.target_image = target_image;
        this.target_subjetcs = target_subjetcs;
    }

    public String getTarget_title() {
        return target_title;
    }

    public void setTarget_title(String target_title) {
        this.target_title = target_title;
    }

    public int getTarget_image() {
        return target_image;
    }

    public void setTarget_image(int target_image) {
        this.target_image = target_image;
    }

    public String[] getTarget_subjetcs() {
        return target_subjetcs;
    }

    public void setTarget_subjetcs(String[] target_subjetcs) {
        this.target_subjetcs = target_subjetcs;
    }
}
