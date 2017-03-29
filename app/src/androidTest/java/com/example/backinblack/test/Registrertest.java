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
public class Registrertest {
    @Rule
    public ActivityTestRule<Main2Activity> mActivityRule =
            new ActivityTestRule<>(Main2Activity.class);



    @Test
    public void emailremeber()
    {
      onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
      onView(withId(R.id.Password)).perform(typeText("abcdefghy"), ViewActions.closeSoftKeyboard());
      onView(withId(R.id.buttonsignup)).perform(click());
      onView(withId((R.id.Email))).check(matches(Errormatcherpopup.withErrorText("email skal indholde @")));
    }



    @Test
    public void emailremeberempty()
    {
        onView(withId(R.id.Email)).perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("abcdefghy"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonsignup)).perform(click());
        onView(withId((R.id.Email))).check(matches(Errormatcherpopup.withErrorText("email må ikke være tom")));
    }

    @Test
    public void password5tegn()
    {
        onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("abcde"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonsignup)).perform(click());
        onView(withId((R.id.Password))).check(matches(Errormatcherpopup.withErrorText("antal tegn skal være mellem 6 og 30")));
    }

    @Test
    public void password31tegn()  {

        onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonsignup)).perform(click());
        onView(withId((R.id.Password))).check(matches(Errormatcherpopup.withErrorText("antal tegn skal være mellem 6 og 30")));
    }

    @Test
    public void passwordisempty()
    {
        onView(withId(R.id.Email)).perform(typeText("jacobballinghotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText(""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonsignup)).perform(click());
        onView(withId((R.id.Password))).check(matches(Errormatcherpopup.withErrorText("passwordfeltet skal være udfyldt")));
    }

     @Test
    public void testtoast()
     {
         onView(withId(R.id.Email)).perform(typeText("mismismismis@hotmail.com"), ViewActions.closeSoftKeyboard());
         onView(withId(R.id.Password)).perform(typeText("roserosevin"), ViewActions.closeSoftKeyboard());
         onView(withId(R.id.buttonsignup)).perform(click());
         onView(withText(getString(R.string.errorrregistrer))).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())));
     }

    @Test
    public void testtoastregistrersucces()
    {
        onView(withId(R.id.Email)).perform(typeText("søren@hotmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.Password)).perform(typeText("roserosevinrosevin"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.buttonsignup)).perform(click());
        onView(withText(getString(R.string.succesregistrer))).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())));
    }

    @Test
    public void withhint()
    {
      onView(withId(R.id.Email)).check(matches(Hintmatcher.withHint("Email")));
        onView(withId(R.id.Password)).check(matches(Hintmatcher.withHint("Password")));
    }

    private String getString(@StringRes int resourceId) {
        return mActivityRule.getActivity().getString(resourceId);
    }
}
