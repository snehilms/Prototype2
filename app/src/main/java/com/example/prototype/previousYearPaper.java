package com.example.prototype;

public class previousYearPaper {
    int paperThumbail;
    String yearName;
    public  previousYearPaper()
    {

    }

    public previousYearPaper(int paperThumbail, String yearName) {
        this.paperThumbail = paperThumbail;
        this.yearName = yearName;
    }

    public int getPaperThumbail() {
        return paperThumbail;
    }

    public void setPaperThumbail(int paperThumbail) {
        this.paperThumbail = paperThumbail;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }
}
