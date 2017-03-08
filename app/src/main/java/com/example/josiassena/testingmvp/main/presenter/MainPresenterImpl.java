package com.example.josiassena.testingmvp.main.presenter;

import android.view.View;

import com.example.josiassena.testingmvp.main.view.MainView;
import com.example.josiassena.testingmvp.utils.Utils;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * File created by josiassena on 3/3/17.
 */
public class MainPresenterImpl extends MvpBasePresenter<MainView> implements MainPresenter {

    @Override
    public void reverseViewVisibility(final View view) {
        if (view != null) {
            if (view.isShown()) {
                Utils.hideView(view);

                setButtonText("Show");
            } else {
                Utils.showView(view);

                setButtonText("Hide");
            }
        }
    }

    private void setButtonText(final String text) {
        if (isViewAttached()) {
            getView().setButtonText(text);
        }
    }
}
