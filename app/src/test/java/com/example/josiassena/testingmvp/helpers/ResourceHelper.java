package com.example.josiassena.testingmvp.helpers;

import android.support.annotation.StringRes;

import org.robolectric.RuntimeEnvironment;

/**
 * File created by josiassena on 4/4/17.
 */
public class ResourceHelper {

    public static String getString(@StringRes int id) {
        return RuntimeEnvironment.application.getString(id);
    }

}
