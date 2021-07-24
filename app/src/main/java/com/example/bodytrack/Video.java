package com.example.bodytrack;

public class Video {
    String videoTitle, url;
    int flag;

    public Video() {
    }

    public Video(String videoTitle, String url, int flag) {
        this.videoTitle = videoTitle;
        this.url = url;
        this.flag = flag;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
