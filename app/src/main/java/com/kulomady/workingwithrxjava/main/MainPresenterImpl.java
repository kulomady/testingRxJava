package com.kulomady.workingwithrxjava.main;

import android.content.res.Resources;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.kulomady.workingwithrxjava.R;
import com.kulomady.workingwithrxjava.data.model.ImageWithText;
import com.kulomady.workingwithrxjava.domain.DefaultSubscriber;
import com.kulomady.workingwithrxjava.domain.GetImageWithString;
import com.kulomady.workingwithrxjava.domain.UseCase;

/**
 *
 * Created by kulomady on 5/16/16.
 */
public class MainPresenterImpl implements MainPresenter {
    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    private final UseCase getImageWithStringUsecase;
    private MainView mainView;

    public MainPresenterImpl(Resources resources) {
        getImageWithStringUsecase = createtUsecaseInteractor(resources);
    }


    private UseCase createtUsecaseInteractor(Resources resources) {
        UseCase getImageWithStringUsecase;
        int drawableId = R.drawable.tokopedia;
        int stringId=R.string.dummy_text;
        int exptectedWidth = 400;
        int expectedHeight=400;
        getImageWithStringUsecase = new GetImageWithString(
                resources,
                drawableId,
                exptectedWidth,
                expectedHeight,
                stringId
                );
        return getImageWithStringUsecase;
    }


    @Override
    public void setView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        this.getImageWithStringUsecase.unsubscribe();
        mainView = null;
    }


    @Override
    public void getImageWithText() {
        mainView.showGetImageAndTextProgress();
        getImageWithStringUsecase.execute(new GetImageWithStringSubscriber());

    }



    @RxLogSubscriber
    private final class GetImageWithStringSubscriber extends DefaultSubscriber<ImageWithText>{
        @Override
        public void onCompleted() {
            mainView.hideGetImageAndTextProgress();
        }

        @Override
        public void onError(Throwable e) {
            mainView.hideGetImageAndTextProgress();
            mainView.showGetImageAndTextErrorMessage(e.getMessage());
        }

        @Override
        public void onNext(ImageWithText imageWithText) {

            mainView.showImageResult(imageWithText);

        }
    }

}
