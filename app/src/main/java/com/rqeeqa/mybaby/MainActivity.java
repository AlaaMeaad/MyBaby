package com.rqeeqa.mybaby;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.rqeeqa.mybaby.interfaces.Communication;
import com.rqeeqa.mybaby.models.AricleModel;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Communication {
int close=0;
    InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String languageToLoad  = "ar"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_main);

    }
    @Override
    public void onBackPressed()
    {
         super.onBackPressed();  // optional depending on your needs
    }

    @Override
    public void onClick(int i) {
        switch (i){
            case 0: Intent intent1=new Intent(MainActivity.this,ArticleShow.class);
               AricleModel m=new AricleModel();
                m.setTitle("تغذية الطفل");
                m.setDesc(getText(R.string.feed_description).toString());
                m.setImage(R.drawable.feed_details);
                intent1.putExtra("article",m);
                startActivity(intent1);
                break;
            case 1:
        Intent intent=new Intent(MainActivity.this,Department.class);
            intent.putExtra("depart","1");
        startActivity(intent);
        break;
            case 2:
                Intent intent3=new Intent(MainActivity.this,Articl.class);
                intent3.putExtra("type",2);
                startActivity(intent3);
                break;
            case 3:
                Intent intent4=new Intent(MainActivity.this,Articl.class);
                intent4.putExtra("type",3);
                startActivity(intent4);
                break;
            case 4:
                Intent intent5=new Intent(MainActivity.this,Articl.class);
                intent5.putExtra("type",4);
                startActivity(intent5);
                break;

            case 5:
                Intent intent6=new Intent(MainActivity.this,Department.class);
                intent6.putExtra("depart","5");
                startActivity(intent6);
                break;

            case 6:
                Intent intent7=new Intent(MainActivity.this,AfrticlsShowWithImages.class);

                intent7.putExtra("number","تطعيمات");
                intent7.putExtra("desc","جدول التطعيمات");
                intent7.putExtra("depart","5");
                startActivity(intent7);
                break;


            case 7:
                Intent intent8=new Intent(Intent.ACTION_VIEW);
                    intent8.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Doctor%20Soft%20App"));
                startActivity(intent8);

                break;

            case 8:
                Intent intent9=new Intent(MainActivity.this,AboutUs.class);

                startActivity(intent9);
                break;


            case 9:
                shareLink();

                break;
        }

    }

    @Override
    public void onClick(AricleModel m) {

    }
    public  void shareLink(){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TITLE, "ماى بيبى");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.rqeeqa.mybaby");

            startActivity(shareIntent);

    }

}
