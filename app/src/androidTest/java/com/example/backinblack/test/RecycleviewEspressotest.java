package com.example.backinblack.test;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.backinblack.espressohovedopgave.OverblikCrystalActivity;
import com.example.backinblack.espressohovedopgave.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
@RunWith(AndroidJUnit4.class)
public class RecycleviewEspressotest {
    @Rule
    public ActivityTestRule<OverblikCrystalActivity> mActivityRule =
            new ActivityTestRule<>(OverblikCrystalActivity.class);

    @Test
    public void Findtekst1()
    {
       onView(withId(R.id.card_recycler_view))
                       .perform(RecyclerViewActions.
                       actionOnItem(hasDescendant(withText("CRYSTAL ClassicMINI - Black & Soft Gold")), click()));
    }

}
