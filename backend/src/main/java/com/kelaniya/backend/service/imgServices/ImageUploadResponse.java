package com.kelaniya.backend.service.imgServices;

public class ImageUploadResponse {

    private String fileName;
    private String imgUploadUrl;
    private long size;


    public String getImgUploadUrl() {
        return imgUploadUrl;
    }

    public void setImgUploadUrl(String imgUploadUrl) {
        this.imgUploadUrl = imgUploadUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}