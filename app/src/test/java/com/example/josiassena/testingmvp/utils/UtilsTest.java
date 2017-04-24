package com.example.josiassena.testingmvp.utils;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * File created by josiassena on 3/3/17.
 */
@RunWith (MockitoJUnitRunner.class)
public class UtilsTest {

    @Mock
    View view;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown(){
        Mockito.reset(view);
    }

    @Test
    public void testShowView() throws Exception {
        // Set visibility to VISIBLE
        Utils.showView(view);
        // Verify that the showView method did what it was supposed to do. Set the view
        // visibility to View.VISIBLE
        Mockito.verify(view).setVisibility(View.VISIBLE);
    }

    @Test
    public void testHideView() throws Exception {
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
        Mockito.verify(view,Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void testHideViewWithNullView() throws Exception {
        // Making sure the method handles null values properly
        Utils.hideView(null);
        Mockito.verify(view,Mockito.never()).setVisibility(View.GONE);
    }
}