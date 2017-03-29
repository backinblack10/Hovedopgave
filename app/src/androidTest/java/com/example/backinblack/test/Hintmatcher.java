package com.example.backinblack.test;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.is;

public class Hintmatcher {

    static Matcher<View> withHint(final String substring) {
        return withHint(is(substring));
    }

    static Matcher<View> withHint(final Matcher<String> stringMatcher) {
        checkNotNull(stringMatcher);
        return new BoundedMatcher<View, EditText>(EditText.class) {

            @Override
            public boolean matchesSafely(EditText view) {
                final CharSequence hint = view.getHint();
                return hint != null && stringMatcher.matches(hint.toString());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with hint: ");
                stringMatcher.describeTo(description);
            }
        };
    }
}
