package com.example.backinblack.test;

import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.util.EventLogTags;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.runner.Description;

/**
 * Created by backinblack on 07-01-2017.
 */
public class Errormatcherpopup {

    public Errormatcherpopup() {
    }

    @NonNull
    public static Matcher<View> withErrorText(final String text) {
        return withErrorText(Matchers.is(text));
    }

    @NonNull
    private static Matcher<View> withErrorText( final Matcher<String> stringMatcher) {
        return new BoundedMatcher<View, TextView>(TextView.class) {

            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("with error text: ");
                stringMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(final TextView textView) {
                return stringMatcher.matches(textView.getError().toString());
            }
        };
    }
}
