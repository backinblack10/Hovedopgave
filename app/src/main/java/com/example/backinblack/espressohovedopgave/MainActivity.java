package com.example.backinblack.espressohovedopgave;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;
import com.localytics.android.Localytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Localytics.registerPush("286439800439");
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        // Facebook del
        ShareButton fbShareButton = (ShareButton) findViewById(R.id.fb_share_button);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle("Hej Folkens")
                .setContentDescription(
                        "Gode tilbud")
                .setContentUrl(Uri.parse("http://www.therubz.com/collections/all"))
                .setImageUrl(Uri.parse("https://www.facebook.com/therubzoriginal/?fref=ts"))
                .build();
        fbShareButton.setShareContent(content);

        // Facebook synes godt om
        LikeView likeView = (LikeView) findViewById(R.id.likeView);
        likeView.setLikeViewStyle(LikeView.Style.BUTTON);
        likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);

        likeView.setObjectIdAndType(
                "https://www.facebook.com/therubzoriginal/?fref=ts",
                LikeView.ObjectType.PAGE);
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);

        Localytics.onNewIntent(this, intent);
    }

    public void tologin(View view)
    {
        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
        startActivity(intent);
    }

    public void tocrystal(View view)
    {
      Intent intent = new Intent(getBaseContext(), OverblikCrystalActivity.class );
        startActivity(intent);
    }

    public void topixel(View view)
    {
      Intent intent = new Intent(getBaseContext(), OverBlikPixelActivity.class);
        startActivity(intent);
    }

    public void toAccessorices(View view)
    {
      Intent intent = new Intent(getBaseContext(), OverBlikNano2PackActivity.class);
        startActivity(intent);
    }

    public void toclassic(View view )
    {
      Intent intent = new Intent(getBaseContext(), OverBlikClassicActivity.class);
        startActivity(intent);
    }

    public void tonewarrivals(View view)
    {
      Intent intent = new Intent(getBaseContext(), OverBlikCircleActivity.class);
        startActivity(intent);
    }

}
