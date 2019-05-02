package com.amalgama.concerts;

public class Concert {
    private String title;
    private String fecha;
    private int imageId;

    public Concert(String title, String fecha, int imageId) {
        this.title = title;
        this.fecha = fecha;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getFecha() {
        return fecha;
    }

    public int getImageId() {
        return imageId;
    }
}
