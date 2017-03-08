package com.example.josiassena.testingmvp.main.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.example.josiassena.testingmvp.R;
import com.example.josiassena.testingmvp.main.presenter.MainPresenter;
import com.example.josiassena.testingmvp.main.presenter.MainPresenterImpl;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    //region View injections using ButterKnife
    @BindView (R.id.toolbar)
    Toolbar toolbar;

    @BindView (R.id.tv_to_show_hide)
    TextView tvToShowHide;

    @BindView (R.id.btn_change_visibility)
    Button btnChangeVisibility;
    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        // bind the presenter to this view/activity
        return new MainPresenterImpl();
    }

    @OnClick (R.id.btn_change_visibility)
    public void onClick() {
        // set the opposite of the current view visibility
        presenter.reverseViewVisibility(tvToShowHide);
    }

    @Override
    public void setButtonText(final String text) {
        // set some text on the button
        btnChangeVisibility.setText(text);
    }
}
