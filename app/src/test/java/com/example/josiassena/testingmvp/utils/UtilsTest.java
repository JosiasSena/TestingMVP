package com.example.josiassena.testingmvp.utils;

import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * File created by josiassena on 3/3/17.
 */
@RunWith (PowerMockRunner.class)
public class UtilsTest {

    @Test
    public void testShowView() throws Exception {
        // Our mocked view object
        final View view = Mockito.mock(View.class);

        // Set visibility to VISIBLE
        Utils.showView(view);

        // Verify that the showView method did what it was supposed to do. Set the view
        // visibility to View.VISIBLE
        Mockito.verify(view).setVisibility(View.VISIBLE);
    }

    @Test
    public void testHideView() throws Exception {
        // Our mocked view object
        final View view = Mockito.mock(View.class);

        // Set visibility to GONE
        Utils.hideView(view);

        // Verify that the showView method did what it was supposed to do. Set the view
        // visibility to View.GONE
        Mockito.verify(view).setVisibility(View.GONE);
    }

    @Test
    public void testShowViewWithNullView() throws Exception {
        // Making sure the method handles null values properly
        Utils.showView(null);
    }

    @Test
    public void testHideViewWithNullView() throws Exception {
        // Making sure the method handles null values properly
        Utils.hideView(null);
    }
}