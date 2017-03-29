package com.example.backinblack.espressohovedopgave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MereInformationActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private TextView textViewnavn;
    public String navn;
    public ImageView imageView;
    public String image;
    private GestureDetector gestureDetector;
    public String Mereiformation;
    public TextView Mereinformationtekst;
    public TextView pristekstview;
    public String pris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mere_information);
        gestureDetector = new GestureDetector(this, this);
        Intent intent = getIntent();
        Mereinformationtekst = (TextView)findViewById(R.id.mereinformationtekstview);
        imageView = (ImageView)findViewById(R.id.imageViewmereinformation);
        textViewnavn =(TextView)findViewById(R.id.Navnsmykke);
        pristekstview =(TextView)findViewById(R.id.textViewprismereinformation);
        Androidklasse androidklassenavn = (Androidklasse)intent.getSerializableExtra(Dataadapter.Navn);
        Androidklasse androidklassenpris = (Androidklasse)intent.getSerializableExtra(Dataadapter.Pris);
        Androidklasse androidklassenmereinformation = (Androidklasse)intent.getSerializableExtra(Dataadapter.Mereinformation);
      //  Androidklasse androidklasseimage = (Androidklasse)intent.getSerializableExtra(Dataadapter.Image);
        navn = androidklassenavn.getDescription();
        pris = androidklassenpris.getPris();
        Mereiformation = androidklassenmereinformation.getMereinformation();

        image = intent.getStringExtra(Dataadapter.Image);

        textViewnavn.setText(navn);
        pristekstview.setText(pris);
        Mereinformationtekst.setText(Mereiformation);
        Picasso.with(MereInformationActivity.this).load(image).resize(400,200).into(imageView);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {

      
        boolean leftSwipe = e1.getY() > e2.getY();

        if (leftSwipe) {
            Intent intent = new Intent(this, BestillingsActivity.class);
            intent.putExtra("image", image);
            intent.putExtra("navn", navn);
            startActivity(intent);
        }
        return true; // done
    }
}
