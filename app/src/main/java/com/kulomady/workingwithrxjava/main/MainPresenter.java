package com.kulomady.workingwithrxjava.main;

/**
 *
 * Created by kulomady on 5/16/16.
 */
public interface MainPresenter {

    void setView(MainView mainView);
    void onStart();
    void onPause();
    void onDestroy();

    void getImageWithText();

}
