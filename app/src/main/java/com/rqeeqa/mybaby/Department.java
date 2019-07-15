package com.rqeeqa.mybaby;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rqeeqa.mybaby.fragments.*;
import com.rqeeqa.mybaby.fragments.Articls;
import com.rqeeqa.mybaby.interfaces.Communication;
import com.rqeeqa.mybaby.models.AricleModel;
import com.rqeeqa.mybaby.models.CatModel;

public class Department extends AppCompatActivity implements Communication{
int depart=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        AdView mAdView= (AdView)findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        FragmentManager fragmentManager = getFragmentManager();
        Articls articls=new Articls();
        MainPage dept=new MainPage();
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        if(getIntent()!=null){
            depart= Integer.parseInt(getIntent().getStringExtra("depart"));
        }

        if (depart==1){
            AricleModel model=new AricleModel();
            model.setTitle(getText(R.string.reda3a_senay_title).toString());
            model.setDesc(getText(R.string.reda3a_senay_desc).toString());
            bundle.putSerializable("model",model);

            CatModel catModel=new CatModel();
            catModel.setName("الرضاعة الطبيعية");
            catModel.setImage(R.drawable.tabe3y);
             bundle2.putSerializable("cat",catModel);

            bundle.putInt("type",-1);
        }
        else if(depart==5){


            CatModel catModel=new CatModel();
            catModel.setName("التطور العقلى و البدنى و النفسى شهر بشهر");
            catModel.setImage(R.drawable.evolution);
            bundle2.putSerializable("cat",catModel);

            bundle.putInt("type",5);
        }

        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        Articls fragment = new Articls();
        fragment.setArguments(bundle);
        ft.replace(R.id.fragment3, fragment);

        MainPage mainPage=new MainPage();
        mainPage.setArguments(bundle2);
        ft.replace(R.id.fragment2, mainPage);
        ft.commit();



    }

    @Override
    public void onClick(int i) {

        Intent intent=new Intent(Department.this,Articl.class);

        if(depart==1){
            intent.putExtra("cat","tabe3y");
            intent.putExtra("type",1);
            startActivity(intent);
        }
        else{
            intent.putExtra("cat","tabe3y");
            intent.putExtra("type",50);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(AricleModel m) {
        if(depart==1||m.getTitle().equals("تطور النطق و الكلام عند الطفل")){
        Intent intent=new Intent(Department.this,ArticleShow.class);
        intent.putExtra("article",m);
        startActivity(intent);}
        else{

            Intent intent=new Intent(Department.this,AfrticlsShowWithImages.class);
            intent.putExtra("number",m.getTitle());
            intent.putExtra("desc",m.getDesc());
            startActivity(intent);
        }
    }

}
