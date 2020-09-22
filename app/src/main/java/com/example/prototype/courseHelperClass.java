package com.example.prototype;

public class courseHelperClass {
    String courseTitle;
    String provider;
    String price;
    int courseImage;

    public courseHelperClass(String courseTitle, String provider, String price, int courseImage) {
        this.courseTitle = courseTitle;
        this.provider = provider;
        this.price = price;
        this.courseImage = courseImage;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }
}
