package com.kulomady.workingwithrxjava.main;

import com.kulomady.workingwithrxjava.data.model.ImageWithText;

/**
 *
 * Created by kulomady on 5/16/16.
 */
public interface MainView {

    void showGetImageAndTextProgress();
    void showGetImageAndTextErrorMessage(String message);

    void hideGetImageAndTextProgress();

    void showImageResult(ImageWithText imageWithText);
}
