package com.rqeeqa.mybaby;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rqeeqa.mybaby.fragments.Articls;
import com.rqeeqa.mybaby.interfaces.Communication;
import com.rqeeqa.mybaby.models.AricleModel;

import java.util.ArrayList;
import java.util.List;

public class Articl extends AppCompatActivity implements Communication{
List<AricleModel>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articls);
        AdView mAdView= (AdView)findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        FragmentManager fragmentManager = getFragmentManager();

        Articls articls=new Articls();

        Bundle bundle = new Bundle();

        bundle.putInt("type",getIntent().getIntExtra("type",-1));
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        articls.setArguments(bundle);
        ft.replace(R.id.fragment, articls);
        ft.commit();


    }

    @Override
    public void onClick(int i) {

    }

    @Override
    public void onClick(AricleModel m) {

        Intent intent=new Intent(Articl.this,ArticleShow.class);
        intent.putExtra("article",m);
        startActivity(intent);
    }
}
