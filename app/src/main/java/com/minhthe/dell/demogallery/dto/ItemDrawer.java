package com.minhthe.dell.demogallery.dto;

/**
 * Created by ttran230 on 8/7/2016.
 */
public class ItemDrawer {
    int ImageItem;
    String TextItem;

    public ItemDrawer(int imageItem, String textItem) {
        ImageItem = imageItem;
        TextItem = textItem;
    }

    public int getImageItem() {
        return ImageItem;
    }

    public void setImageItem(int imageItem) {
        ImageItem = imageItem;
    }

    public String getTextItem() {
        return TextItem;
    }

    public void setTextItem(String textItem) {
        TextItem = textItem;
    }
}
