package com.kulomady.workingwithrxjava.main;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kulomady.workingwithrxjava.R;
import com.kulomady.workingwithrxjava.data.model.ImageWithText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    private static final String TAG = "MainActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.coordinatlayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.form_view)
    RelativeLayout formView;
    @BindView(R.id.textview)
    TextView textView;
    @BindView(R.id.imageview)
    ImageView imageView;

    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        presenter = new MainPresenterImpl(getResources());
        presenter.setView(this);

    }

    @Override
    public void showGetImageAndTextProgress() {
        formView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showGetImageAndTextErrorMessage(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideGetImageAndTextProgress() {
        formView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showImageResult(ImageWithText imageWithText) {
        imageView.setImageBitmap(imageWithText.getBitmap());
        textView.setText(imageWithText.getText());
        Log.d(TAG, "showImageResult: " + imageWithText.getText() + "\nbitmap is : " + imageWithText.getBitmap());

    }

    @OnClick(R.id.fab)
    void onFabButtonClicked() {
        presenter.getImageWithText();
    }
}
