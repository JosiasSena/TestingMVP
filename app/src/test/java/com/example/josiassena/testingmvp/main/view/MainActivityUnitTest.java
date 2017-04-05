package com.example.josiassena.testingmvp.main.view;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.josiassena.testingmvp.BuildConfig;
import com.example.josiassena.testingmvp.R;
import com.example.josiassena.testingmvp.helpers.AssertHelper;
import com.example.josiassena.testingmvp.helpers.ResourceHelper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * File created by josiassena on 3/21/17.
 */
@RunWith (RobolectricTestRunner.class)
@Config (constants = BuildConfig.class, sdk = 21)
public class MainActivityUnitTest {

    private MainActivity activity;
    private ActionBar actionBar;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
        actionBar = activity.getSupportActionBar();
    }

    @Test
    public void testToolbarIsVisible() {
        AssertHelper.assertActionBarVisible(actionBar);
    }

    @Test
    public void testToolbarHasProperText() throws Exception {
        Assert.assertEquals(ResourceHelper.getString(R.string.app_name), activity.getTitle());
    }

    @Test
    public void testTextViewHasCorrectInitialText() {
        final TextView textView = (TextView) activity.findViewById(R.id.tv_to_show_hide);
        final String expected = ResourceHelper.getString(R.string.hello_world);

        AssertHelper.assertVisible(textView);
        Assert.assertEquals(expected, textView.getText().toString());
    }

    @Test
    public void testButtonHasCorrectInitialText() throws Exception {
        final Button button = (Button) activity.findViewById(R.id.btn_change_visibility);
        final String expected = ResourceHelper.getString(R.string.hide);

        AssertHelper.assertVisible(button);
        Assert.assertEquals(expected, button.getText().toString());
    }

    @Test
    public void testButtonClickHidesTextView() throws Exception {
        final TextView textView = (TextView) activity.findViewById(R.id.tv_to_show_hide);
        final Button button = (Button) activity.findViewById(R.id.btn_change_visibility);

        AssertHelper.assertVisible(textView);
        AssertHelper.assertVisible(button);

        button.performClick();

        Assert.assertFalse(textView.isShown());
    }

    @Test
    public void testButtonHasProperTextAfterHidingTextView() throws Exception {
        final TextView textView = (TextView) activity.findViewById(R.id.tv_to_show_hide);
        final Button button = (Button) activity.findViewById(R.id.btn_change_visibility);

        AssertHelper.assertVisible(textView);
        AssertHelper.assertVisible(button);

        button.performClick();

        Assert.assertEquals(ResourceHelper.getString(R.string.show), button.getText().toString());
    }

    @Test
    public void testButtonClickShowsTextView() throws Exception {
        final TextView textView = (TextView) activity.findViewById(R.id.tv_to_show_hide);
        final Button button = (Button) activity.findViewById(R.id.btn_change_visibility);

        textView.setVisibility(View.GONE);

        AssertHelper.assertHidden(textView);
        AssertHelper.assertVisible(button);

        button.performClick();

        Assert.assertTrue(textView.isShown());

        final String expected = ResourceHelper.getString(R.string.hello_world);
        Assert.assertEquals(expected, textView.getText().toString());
    }

    @Test
    public void testButtonHasProperTextAfterShowingTextView() throws Exception {
        final TextView textView = (TextView) activity.findViewById(R.id.tv_to_show_hide);
        final Button button = (Button) activity.findViewById(R.id.btn_change_visibility);
        textView.setVisibility(View.GONE);

        AssertHelper.assertHidden(textView);
        AssertHelper.assertVisible(button);

        button.performClick();

        final String expected = ResourceHelper.getString(R.string.hide);
        Assert.assertEquals(expected, button.getText().toString());
    }
}