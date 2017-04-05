package com.example.josiassena.testingmvp.helpers;

import android.support.v7.app.ActionBar;
import android.view.View;

import org.junit.Assert;

/**
 * File created by josiassena on 4/4/17.
 */
public class AssertHelper {

    public static void assertVisible(final View view) {
        Assert.assertNotNull(view);
        Assert.assertTrue(view.isShown());
    }

    public static void assertHidden(final View view) {
        Assert.assertNotNull(view);
        Assert.assertFalse(view.isShown());
    }

    public static void assertActionBarVisible(final ActionBar actionBar) {
        Assert.assertNotNull(actionBar);
        Assert.assertTrue(actionBar.isShowing());
    }
}
