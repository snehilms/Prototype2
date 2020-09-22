package com.example.prototype;

public class recorded {
    String topicName;
    String companyName;
    String link;
    String duration;
    int recordedThumbnail;

    public recorded()
    {}

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getRecordedThumbnail() {
        return recordedThumbnail;
    }

    public void setRecordedThumbnail(int recordedThumbnail) {
        this.recordedThumbnail = recordedThumbnail;
    }

    public recorded(String topicName, String companyName, String link, String duration, int recordedThumbnail) {
        this.topicName = topicName;
        this.companyName = companyName;
        this.link = link;
        this.duration = duration;
        this.recordedThumbnail = recordedThumbnail;
    }
}
