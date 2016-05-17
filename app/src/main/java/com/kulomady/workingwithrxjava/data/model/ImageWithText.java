package com.kulomady.workingwithrxjava.data.model;

import android.graphics.Bitmap;

/**
 *
 * Created by kulomady on 5/16/16.
 */
public class ImageWithText {

    private Bitmap bitmap;
    private String text;

    public ImageWithText(Bitmap bitmap, String text) {
        this.bitmap = bitmap;
        this.text = text;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getText() {
        return text;
    }
}
