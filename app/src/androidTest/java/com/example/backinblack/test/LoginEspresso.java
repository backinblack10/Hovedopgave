package com.example.backinblack.test;

import android.support.annotation.StringRes;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.backinblack.espressohovedopgave.Main2Activity;
import com.example.backinblack.espressohovedopgave.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
@RunWith(AndroidJUnit4.class)
public class LoginEspresso {

    @Rule
    public ActivityTestRule<Main2Activity> mActivityRule =
            new ActivityTestRule<>(Main2Activity.class);


    @Test
    public void emailremeberlogin()
    {
        onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("abcdefghy"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signin)).perform(click());
        onView(withId((R.id.Email))).check(matches(Errormatcherpopup.withErrorText("email skal indholde @")));
    }

    @Test
    public void emailremeberemptylogin()
    {

        onView(withId(R.id.Email)).perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("abcdefghy"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signin)).perform(click());
        onView(withId((R.id.Email))).check(matches(Errormatcherpopup.withErrorText("email må ikke være tom")));
    }



    @Test
    public void password5tegnlogin()
    {
        onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("abcde"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signin)).perform(click());
        onView(withId((R.id.Password))).check(matches(Errormatcherpopup.withErrorText("antal tegn skal være mellem 6 og 30")));
    }

    @Test
    public void password31tegnlogin()
    {
        onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signin)).perform(click());
        onView(withId((R.id.Password))).check(matches(Errormatcherpopup.withErrorText("antal tegn skal være mellem 6 og 30")));
    }

    @Test
    public void passwordisemptylogin()
    {
        onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signin)).perform(click());
        onView(withId((R.id.Password))).check(matches(Errormatcherpopup.withErrorText("passwordfeltet skal være udfyldt")));
    }

    @Test
    public void loginsucces()
    {

      onView(withId(R.id.Email)).perform(typeText("jacob.balling@hotmail.com"), ViewActions.closeSoftKeyboard());
      onView(withId(R.id.Password)).perform(typeText("Albusseverus10"), ViewActions.closeSoftKeyboard());
      onView(withId(R.id.signin)).perform(click());
    }

    @Test
    public void testfail()
    {
        onView(withId(R.id.Email)).perform(typeText("testtest@hotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("12345678hdfb"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.signin)).perform(click());
        onView(withText(getString(R.string.loginfail))).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())));
    }
    private String getString(@StringRes int resourceId) {
        return mActivityRule.getActivity().getString(resourceId);
    }

}
