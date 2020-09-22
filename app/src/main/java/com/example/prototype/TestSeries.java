package com.example.prototype;

public class TestSeries {

    String seriesName;
    String seriesCompany;
    int price;
    int seriesThumbnail;

    public  TestSeries()
    {}

    public TestSeries(String seriesName, String seriesCompany, int price, int seriesThumbnail) {
        this.seriesName = seriesName;
        this.seriesCompany = seriesCompany;
        this.price = price;
        this.seriesThumbnail = seriesThumbnail;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesCompany() {
        return seriesCompany;
    }

    public void setSeriesCompany(String seriesCompany) {
        this.seriesCompany = seriesCompany;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeriesThumbnail() {
        return seriesThumbnail;
    }

    public void setSeriesThumbnail(int seriesThumbnail) {
        this.seriesThumbnail = seriesThumbnail;
    }
}
