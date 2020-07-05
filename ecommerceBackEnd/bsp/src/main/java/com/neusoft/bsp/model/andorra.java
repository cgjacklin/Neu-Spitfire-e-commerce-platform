package com.neusoft.bsp.model;

import java.util.Date;

public class andorra {
    private Long id;

    private String title;

    private String content;

    private String type;

    private String adurl;

    private String publisher;

    private Date addtime;

    private Date uptime;

    private String starttime;

    private String endtime;

    private String status;

    private String tourl;

    public andorra(Long id, String title, String content, String type, String adurl, String publisher, Date addtime, Date uptime, String starttime, String endtime, String status, String tourl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.adurl = adurl;
        this.publisher = publisher;
        this.addtime = addtime;
        this.uptime = uptime;
        this.starttime = starttime;
        this.endtime = endtime;
        this.status = status;
        this.tourl = tourl;
    }

    public andorra() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAdurl() {
        return adurl;
    }

    public void setAdurl(String adurl) {
        this.adurl = adurl == null ? null : adurl.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTourl() {
        return tourl;
    }

    public void setTourl(String tourl) {
        this.tourl = tourl == null ? null : tourl.trim();
    }
}