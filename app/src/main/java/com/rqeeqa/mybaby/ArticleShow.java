package com.rqeeqa.mybaby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rqeeqa.mybaby.models.AricleModel;

public class ArticleShow extends AppCompatActivity {
TextView title,descPart1,descPart2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_show);
        title= (TextView) findViewById(R.id.title);
        descPart1= (TextView) findViewById(R.id.descPart1);
        descPart2= (TextView) findViewById(R.id.descPart2);
        imageView= (ImageView) findViewById(R.id.imageView);
        AdView mAdView1= (AdView)findViewById(R.id.adView);

        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest1);

        AdView mAdView= (AdView) findViewById(R.id.adView3);
        //mAdView.setAdSize(AdSize.FULL_WIDTH)
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
       AricleModel model= (AricleModel) getIntent().getSerializableExtra("article");
        title.setText(model.getTitle());
try {
    if(model.getImage()!=0){
    imageView.setImageResource(model.getImage());

    imageView.setVisibility(View.VISIBLE);}
}
catch (OutOfMemoryError e){}
        String [] parts=model.getDesc().split("q");
        descPart1.setText(parts[0]);
        descPart2.setText(parts[1]);

    }
}
