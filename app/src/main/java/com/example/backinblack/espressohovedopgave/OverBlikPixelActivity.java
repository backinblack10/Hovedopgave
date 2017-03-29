package com.example.backinblack.espressohovedopgave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class OverBlikPixelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_blik_pixel);
        initViews();
    }
    private final String android_mereinformation[] =
            {
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

            };

    private final String androidnavn[] = {
            "Pixel20mm - Dark Olive & Rose Gold",

    };

    public final String android_billeder[] = {
            "http://cdn.shopify.com/s/files/1/0591/3165/products/bracelet-pixel-dark-olive-rose-gold-1_grande.jpg?v=1463000752"

    };

    private final String android_Pris[] = {
            "350"
    };
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_viewpixelactivity);
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
