package com.example.backinblack.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.backinblack.espressohovedopgave.MainActivity;
import com.example.backinblack.espressohovedopgave.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class EspressoFacebookoglocalyticstest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class, true, false );

     UiDevice mDevice;
    final int timeOut = 100 * 60;
    @Before
    public void setUp()  {
        mActivityRule.launchActivity(new Intent());
         mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    }

  //  @Test
    public void facebookshare() throws Exception
    {


        onView(withId(R.id.fb_share_button)).perform(click());
        mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);

        UiObject Input = mDevice.findObject(new UiSelector()
                .instance(0)
                .className(EditText.class));

        Input.waitForExists(timeOut);
        Input.setText("test");

        UiObject Textview = mDevice.findObject(new UiSelector().text("Slå op"));
        Textview.waitForExists(timeOut);
        Textview.click();
    }

   // @Test
    public void facebooklike() throws Exception
    {
      onView(withId(R.id.likeView));
        mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);

        UiObject back = mDevice.findObject(new UiSelector().instance(0).className(Button.class));

        back.waitForExists(timeOut);
        back.clickAndWaitForNewWindow();
    }


    @Test
    public void facebookshareregression() throws Exception
    {
        mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);
        UiObject cancel = mDevice.findObject(new UiSelector().instance(0).className(View.class));
        cancel.waitForExists(1000);
        cancel.click();
        onView(withId(R.id.fb_share_button)).perform(click());
        mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);

        UiObject Input = mDevice.findObject(new UiSelector()
                .instance(0)
                .className(EditText.class));

        Input.waitForExists(timeOut);
        Input.setText("test");
        UiObject Textview = mDevice.findObject(new UiSelector().text("Slå op"));
        Textview.waitForExists(timeOut);
        Textview.click();
        onView(withText(getString(R.string.Facebooktoast))).
                inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())));

    }
    private String getString(@StringRes int resourceId) {
        return mActivityRule.getActivity().getString(resourceId);
    }

    @Test
    public void facebooklikeregressiontest() throws Exception
    {
        mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);
        UiObject cancel = mDevice.findObject(new UiSelector().instance(0).className(View.class));
        cancel.waitForExists(1000);
        cancel.click();

        onView(withId(R.id.likeView));
        mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);

        UiObject back = mDevice.findObject(new UiSelector().instance(0).className(Button.class));
        back.waitForExists(timeOut);
        back.clickAndWaitForNewWindow();
    }

    @Test
    public void therubzinapp()  throws Exception
    {

        mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);
        UiObject therubz = mDevice.findObject(new UiSelector().instance(2).className(View.class));
        therubz.waitForExists(1000);
        therubz.click();
    }

}
