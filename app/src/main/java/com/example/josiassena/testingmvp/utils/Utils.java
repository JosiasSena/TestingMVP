package com.example.josiassena.testingmvp.utils;

import android.view.View;

/**
 * File created by josiassena on 3/3/17.
 */
public final class Utils {

    /**
     * Suppress default constructor for noninstantiability
     */
    private Utils() {
        throw new AssertionError();
    }

    /**
     * Makes a view visible
     * @param view - the view to set visible
     */
    public static void showView(View view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Makes a view invisible
     * @param view - the view to set hide
     */
    public static void hideView(View view) {
        if (view != null) {
            view.setVisibility(View.GONE);
        }
    }
}
