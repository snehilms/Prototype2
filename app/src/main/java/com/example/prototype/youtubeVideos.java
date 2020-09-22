package com.example.prototype;

public class youtubeVideos {
    public String videoname;
    public String channelTitle;
    public String thumbnail;
    public String videoplaylistid;
    public String type;
    public String descriptionDetail;
    public youtubeVideos()
    {}

    public youtubeVideos(String videoname, String channelTitle, String thumbnail, String videoplaylistid, String type, String descriptionDetail) {
        this.videoname = videoname;
        this.channelTitle = channelTitle;
        this.thumbnail = thumbnail;
        this.videoplaylistid = videoplaylistid;
        this.type = type;
        this.descriptionDetail = descriptionDetail;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideoplaylistid() {
        return videoplaylistid;
    }

    public void setVideoplaylistid(String videoplaylistid) {
        this.videoplaylistid = videoplaylistid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }
}
