package com.example.backinblack.test;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;

import com.example.backinblack.espressohovedopgave.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SwipeEspressoTest {


    @Test
    public void swipeleftandright()  {
        onView(withId(R.id.crystalcardview)).perform(click());
        onView(withId(R.id.card_recycler_view))
                .perform(RecyclerViewActions.
                        actionOnItem(hasDescendant(withText("CRYSTAL ClassicMINI - Black & Soft Gold")), click()));
        onView(withId(R.id.textViewtherubzlogomereinformation)).perform(swipeLeft()).perform(swipeRight());
    }

}


