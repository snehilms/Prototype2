package com.example.prototype;

public class liveClasses {
    String topicName;
    String compantName;
    int classThumbnail;
    String classLink;

    public  liveClasses()
    {}

    public liveClasses(String topicName, String compantName, int classThumbnail, String classLink) {
        this.topicName = topicName;
        this.compantName = compantName;
        this.classThumbnail = classThumbnail;
        this.classLink = classLink;
    }


    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCompantName() {
        return compantName;
    }

    public void setCompantName(String compantName) {
        this.compantName = compantName;
    }

    public int getClassThumbnail() {
        return classThumbnail;
    }

    public void setClassThumbnail(int classThumbnail) {
        this.classThumbnail = classThumbnail;
    }

    public String getClassLink() {
        return classLink;
    }

    public void setClassLink(String classLink) {
        this.classLink = classLink;
    }
}
