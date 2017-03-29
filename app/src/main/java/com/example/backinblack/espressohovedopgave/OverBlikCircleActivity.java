package com.example.backinblack.espressohovedopgave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class OverBlikCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_blik_new_arrivals);
        initViews();
    }
    private final String android_mereinformation[] =
            {
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

            };

    private final String androidnavn[] = {
            "Circle25mm - Black & Metal Mix",

    };

    public final String android_billeder[] = {
            "http://shop2448.hstatic.dk/upload_dir/shop/produkter/The-Rubz/Circle/The-Rubz-Circle-Black.w610.h610.fill.jpg"

    };

    private final String android_Pris[] = {
            "250"
    };
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_viewcircle);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList smykkekollection = prepareData();
        Dataadapter adapter = new Dataadapter(getApplicationContext(),smykkekollection);
        recyclerView.setAdapter(adapter);
    }
    private ArrayList prepareData(){

        ArrayList<Androidklasse> smykkekollectionprepareData = new ArrayList<>();
        for(int i=0;i< androidnavn.length;i++){
            Androidklasse androidklasse = new Androidklasse();
            androidklasse.setDescription(androidnavn[i]);
            androidklasse.setImage(android_billeder[i]);
            androidklasse.setPris(android_Pris[i]);
            androidklasse.setMereinformation(android_mereinformation[i]);
            smykkekollectionprepareData.add(androidklasse);
        }
        return smykkekollectionprepareData;
    }
}
