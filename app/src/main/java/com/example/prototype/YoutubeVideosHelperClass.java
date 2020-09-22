package com.example.prototype;

public class YoutubeVideosHelperClass {
    String youtubeId;
    String thumbnail;
    String title;
    String channelTitle;
    String descriptionDetail;

    public YoutubeVideosHelperClass(String youtubeId, String thumbnail, String title, String channelTitle, String descriptionDetail) {
        this.youtubeId = youtubeId;
        this.thumbnail = thumbnail;
        this.title = title;
        this.channelTitle = channelTitle;
        this.descriptionDetail = descriptionDetail;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }
}
