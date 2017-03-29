package com.example.backinblack.espressohovedopgave;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by backinblack on 06-01-2017.
 */
public class Dataadapter extends RecyclerView.Adapter<Dataadapter.ViewHolder> {
    public ArrayList<Androidklasse> androidklasse;
    private Context context;
    public static final String Navn = "navn";
    public static final String Image = "image";
    public static final String Pris = "pris";
    public static final String Mereinformation = "Mereinformation";


    public Dataadapter( Context context ,ArrayList<Androidklasse> androidklasse) {
        this.context = context;
        this.androidklasse = androidklasse;
    }

    @Override
    public Dataadapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycleview, viewGroup, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {
        holder.tv_android.setText(androidklasse.get(i).getDescription());
        Picasso.with(context).load(androidklasse.get(i).getImage()).resize(600,600).into(holder.img_android);
        holder.tv_androidpris.setText(androidklasse.get(i).getPris());


    }

    @Override
    public int getItemCount() {
        return androidklasse.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_android;
        ImageView img_android;
        TextView tv_androidpris;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView)view.findViewById(R.id.img_android);
            tv_androidpris =(TextView)view.findViewById(R.id.tv_androidpris);
              view.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      Intent intent = new Intent(getApplicationContext(), MereInformationActivity.class);
                      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                      for ( int i=0; i<androidklasse.size(); i++) {

                          intent.putExtra(Image, androidklasse.get(i).getImage());
                          intent.putExtra(Navn, androidklasse.get(i));
                            intent.putExtra(Pris, androidklasse.get(i));
                          intent.putExtra(Mereinformation, androidklasse.get(i));

                      }
                      context.startActivity(intent);
                  }
              });
        }
    }
}







