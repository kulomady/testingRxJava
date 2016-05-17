package com.kulomady.workingwithrxjava.data.datasource;

import android.content.res.Resources;

import rx.Observable;
import rx.Subscriber;

/**
 *
 * Created by kulomady on 5/16/16.
 */
public class StringDataSource {

    public Observable<String> getTextFromAsset(Resources resources,int stringResId){

        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    String result = resources.getString(stringResId);
                    subscriber.onNext(result);
                    subscriber.onCompleted();
                }catch(Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }
}
