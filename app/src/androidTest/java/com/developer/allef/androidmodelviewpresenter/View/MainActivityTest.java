package com.developer.allef.androidmodelviewpresenter.View;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.developer.allef.androidmodelviewpresenter.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.txtlogin), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.txtlogin), isDisplayed()));
        appCompatEditText2.perform(replaceText("Allef"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.txtsenha), isDisplayed()));
        appCompatEditText3.perform(replaceText("Allef"), closeSoftKeyboard());

        ViewInteraction editText = onView(
                allOf(withId(R.id.txtlogin),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.labellogin),
                                        0),
                                0),
                        isDisplayed()));
        editText.check(matches(withText("Allef")));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.txtsenha), withText("Allef"), isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.txtsenha),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.labesenha),
                                        0),
                                0),
                        isDisplayed()));
        editText2.check(matches(withText("Allef")));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnlogar), withText("Sing In"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
