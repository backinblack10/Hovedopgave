package com.example.backinblack.espressohovedopgave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class OverblikCrystalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overblik_assecories);
        initViews();

    }

    private final String android_mereinformation[] =
            {
              "Lorem ipsum dolor sit amet."

            };

    private final String androidnavn[] = {
            "CRYSTAL ClassicMINI - Black & Soft Gold",

    };

    public final String android_billeder[] = {
            "http://cdn.shopify.com/s/files/1/0591/3165/products/100296_CrystalMini_Vlack-Soft_gold_grande.jpg?v=1463000508"

    };

    private final String android_Pris[] = {
             "206"
    };
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
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
