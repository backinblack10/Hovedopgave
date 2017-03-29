package com.example.backinblack.espressohovedopgave;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BestillingsActivity extends AppCompatActivity  {
   private ArrayList<Androidklasse> smykkearraylist = new ArrayList<>();
    private String navnbestilling;

    private GestureDetector gestureDetector;
    public String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestillings);

        smykkearraylist.add(new Androidklasse( image ,navnbestilling));
        ArrayAdapter<Androidklasse> adapter = new smykkeadapter(this, 0, smykkearraylist);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return DoIt(e1, e2);
            }

            private boolean DoIt(MotionEvent e1, MotionEvent e2) {
                boolean swiperight = e1.getY() < e2.getY();
                if (swiperight) {
                    finish();
                }
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return DoIt(e1, e2);
            }
        });

}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
  public   class  smykkeadapter extends ArrayAdapter<Androidklasse> {
        public Context context;
        private List<Androidklasse> smykkeliste;
        public View view;
        public Androidklasse smykkerfromactivity;
        public smykkeadapter(Context context, int resource, ArrayList<Androidklasse> objects) {
            super(context, resource, objects);
            this.context = context;
            this.smykkeliste = objects;
        }


        public  View getView(int position, View viewcontent, ViewGroup parent)
        {

            LayoutInflater inflate = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            view = inflate.inflate(R.layout.bestilingoverbliklistview, null);

            TextView navn = (TextView)view.findViewById(R.id.textViewbestillingnavn);
            ImageView  imageView = (ImageView) view.findViewById(R.id.imageViewbilledenavn);
            Intent intent = getIntent();
            image = intent.getStringExtra("image");
            navnbestilling = intent.getStringExtra("navn");
            navn.setText(navnbestilling);

              Picasso.with(BestillingsActivity.this).load(image).into(imageView);

            return view;
        }
}
    public void tologin(View view)
    {
        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
        startActivity(intent);
    }
}

