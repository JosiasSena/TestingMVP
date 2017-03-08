package com.example.josiassena.testingmvp.main.presenter;

import android.view.View;

import com.example.josiassena.testingmvp.main.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * File created by josiassena on 3/3/17.
 */
@RunWith (PowerMockRunner.class)
public class MainPresenterImplTest {

    @Mock
    MainPresenterImpl presenter; // Mock the presenter

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        // make sure that when the presenters isViewAttached() method is called we return true
        when(presenter.isViewAttached()).thenReturn(true);

        // make sure we return some sort of view type when the getView() is called.
        when(presenter.getView()).thenReturn(mock(MainView.class));

        // when the presenters reverseViewVisibility() method is called, lets make sure tghe
        // actual method is called instead of a mocked one.
        doCallRealMethod().when(presenter).reverseViewVisibility(any(View.class));
    }

    @Test
    public void testReverseViewVisibilityFromVisibleToGone() throws Exception {
        // a mocked view to use for this test
        final View view = Mockito.mock(View.class);

        // when the views isShown() method is called, lets return true
        when(view.isShown()).thenReturn(true);

        // call the presenters reverseViewVisibility method
        presenter.reverseViewVisibility(view);

        // verify that the views setVisibility was called at least once to set the visibility to
        // View.GONE
        Mockito.verify(view, Mockito.atLeastOnce()).setVisibility(View.GONE);

        // verify that the presenters attached view was called at least once, to set
        // some sort of text to the button by calling the setButtonText method
        Mockito.verify(presenter.getView(), Mockito.atLeastOnce()).setButtonText(anyString());
    }

    @Test
    public void testReverseViewVisibilityFromGoneToVisible() throws Exception {
        // a mocked view to use for this test
        final View view = Mockito.mock(View.class);

        // when the views isShown() method is called, lets return false
        when(view.isShown()).thenReturn(false);

        // call the presenters reverseViewVisibility method
        presenter.reverseViewVisibility(view);

        // verify that the views setVisibility was called at least once to set the visibility to
        // View.VISIBLE
        Mockito.verify(view, Mockito.atLeastOnce()).setVisibility(View.VISIBLE);

        // verify that the presenters attached view was called at least once, to set
        // some sort of text to the button by calling the setButtonText method
        Mockito.verify(presenter.getView(), Mockito.atLeastOnce()).setButtonText(anyString());
    }
}