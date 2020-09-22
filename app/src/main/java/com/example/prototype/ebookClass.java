package com.example.prototype;

public class ebookClass {
    String booktitle;
    int bookthumbnail;
    String bookUrl;

    public ebookClass()
    {}


    public ebookClass(String booktitle, int bookthumbnail, String bookUrl) {
        this.booktitle = booktitle;
        this.bookthumbnail = bookthumbnail;
        this.bookUrl = bookUrl;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getBookthumbnail() {
        return bookthumbnail;
    }

    public void setBookthumbnail(int bookthumbnail) {
        this.bookthumbnail = bookthumbnail;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }
}
