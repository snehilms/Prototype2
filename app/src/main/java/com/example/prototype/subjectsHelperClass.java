package com.example.prototype;

public class subjectsHelperClass {
    String subjectName;
    int subjectImage;

    public subjectsHelperClass(String subjectName, int subjectImage) {
        this.subjectName = subjectName;
        this.subjectImage = subjectImage;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectImage() {
        return subjectImage;
    }

    public void setSubjectImage(int subjectImage) {
        this.subjectImage = subjectImage;
    }
}
