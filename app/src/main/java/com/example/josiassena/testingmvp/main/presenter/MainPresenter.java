package com.example.josiassena.testingmvp.main.presenter;

import android.view.View;

import com.example.josiassena.testingmvp.main.view.MainView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * File created by josiassena on 3/3/17.
 */
public interface MainPresenter extends MvpPresenter<MainView> {

    void reverseViewVisibility(final View view);

}
