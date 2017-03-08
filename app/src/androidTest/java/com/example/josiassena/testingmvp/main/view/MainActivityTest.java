package com.example.josiassena.testingmvp.main.view;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.example.josiassena.testingmvp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

@RunWith (AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testToolbarDesign() {
        // Check that the tool ba is displayed
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));

        // Check that the toolbar title is set to "TestingMVP"
        onView(withText(R.string.app_name)).check(matches(withParent(withId(R.id.toolbar))));

        // Verify the toolbar background matches the primary color
        onView(withId(R.id.toolbar)).check(matches(withToolbarBackGroundColor()));
    }

    @Test
    public void testHideShowTextView() {

        // Check the TextView is displayed with the right text
        onView(withId(R.id.tv_to_show_hide)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_to_show_hide)).check(matches(withText("Hello World!")));

        // Check the button is displayed with the right initial text
        onView(withId(R.id.btn_change_visibility)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_change_visibility)).check(matches(withText("Hide")));

        // Click on the button
        onView(withId(R.id.btn_change_visibility)).perform(click());

        // Check that the TextView is now hidden
        onView(withId(R.id.tv_to_show_hide)).check(matches(not(isDisplayed())));

        // Check that the button has the proper text
        onView(withId(R.id.btn_change_visibility)).check(matches(withText("Show")));

        // Click on the button
        onView(withId(R.id.btn_change_visibility)).perform(click());

        // Check the TextView is displayed again with the right text
        onView(withId(R.id.tv_to_show_hide)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_to_show_hide)).check(matches(withText("Hello World!")));

        // Check that the button has the proper text
        onView(withId(R.id.btn_change_visibility)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_change_visibility)).check(matches(withText("Hide")));
    }

    private Matcher<? super View> withToolbarBackGroundColor() {
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            public boolean matchesSafely(View view) {
                // Get the toolbar background as a ColorDrawable
                final ColorDrawable buttonColor = (ColorDrawable) view.getBackground();

                // Match the toolbar background to the apps primary color
                return ContextCompat
                        .getColor(activityTestRule.getActivity(), R.color.colorPrimary) ==
                        buttonColor.getColor();
            }

            @Override
            public void describeTo(Description description) {
                // do nothing, we could technically add some additional text to the description
                // here if wanted
            }
        };
    }
}
