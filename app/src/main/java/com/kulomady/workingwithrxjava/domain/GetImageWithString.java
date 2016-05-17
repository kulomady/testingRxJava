package com.kulomady.workingwithrxjava.domain;

import android.content.res.Resources;

import com.kulomady.workingwithrxjava.data.datasource.ImageDataSource;
import com.kulomady.workingwithrxjava.data.datasource.StringDataSource;
import com.kulomady.workingwithrxjava.data.model.ImageWithText;

import rx.Observable;

/**
 *
 * Created by kulomady on 5/16/16.
 */
public class GetImageWithString extends UseCase {

    private Resources resources;
    private final int resId;
    private final int reqWidth;
    private final int reqHeight;
    private final int stringResId;
    private final ImageDataSource imageDataSource;
    private final StringDataSource stringDataSource;

    public GetImageWithString(Resources resources, int resId,
                              int reqWidth, int reqHeight, int stringResId) {
        this.resources = resources;
        this.resId = resId;
        this.reqWidth = reqWidth;
        this.reqHeight = reqHeight;
        this.stringResId = stringResId;

        this.imageDataSource = new ImageDataSource();
        this.stringDataSource = new StringDataSource();

    }


    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    @Override
    protected Observable buildUseCaseObservable() {
        return Observable.zip(imageDataSource.compressBitmap(resources, resId, reqWidth, reqHeight)
                , stringDataSource.getTextFromAsset(resources, stringResId), ImageWithText::new);
    }

}
