package com.example.backinblack.test;


import android.support.annotation.StringRes;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.backinblack.espressohovedopgave.R;
import com.example.backinblack.espressohovedopgave.ResetPasswordActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
@RunWith(AndroidJUnit4.class)
public class Restpasswordespresso {
    @Rule
    public ActivityTestRule<ResetPasswordActivity> mActivityRule =
            new ActivityTestRule<>(ResetPasswordActivity.class);


    @Test
    public void emailremeberpasswordsuccess() {
        onView(withId(R.id.emailglemtpassword)).perform(typeText("jacobballing@hotmail.com"), ViewActions.closeSoftKeyboard() );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.Sendemialbutton)).perform(click());
        onView(withText(getString(R.string.succestilsendtemail))).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())));
    }

    @Test
    public void emailremeberpasswordfail() {
        onView(withId(R.id.emailglemtpassword)).perform(typeText("klein@gmail.com"), ViewActions.closeSoftKeyboard());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.Sendemialbutton)).perform(click());
        onView(withText(getString(R.string.errorrrtilsendtemail))).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())));

    }

    private String getString(@StringRes int resourceId) {
        return mActivityRule.getActivity().getString(resourceId);
    }
}
