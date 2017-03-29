package com.example.backinblack.espressohovedopgave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class OverBlikNano2PackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_blik_accessorices);
        initViews();
    }
    private final String android_mereinformation[] =
            {
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

            };

    private final String androidnavn[] = {
            "Nano 2-pack - Autumn Mix & Soft Gold",

    };

    public final String android_billeder[] = {
            "http://cdn.shopify.com/s/files/1/0591/3165/products/Skaermbillede_2017-02-06_kl._21.36.23_grande.png?v=1486413419"

    };

    private final String android_Pris[] = {
            "400"
    };
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_viewaccessorices);
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
