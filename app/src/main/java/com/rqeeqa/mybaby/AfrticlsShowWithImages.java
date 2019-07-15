package com.rqeeqa.mybaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rqeeqa.mybaby.adapters.ImagesAdapter;
import com.rqeeqa.mybaby.interfaces.Communication;
import com.rqeeqa.mybaby.models.AricleModel;

import java.util.ArrayList;
import java.util.List;

public class AfrticlsShowWithImages extends AppCompatActivity implements Communication {


    RecyclerView recyclerView;
    ImagesAdapter adapter;
    List<Integer> articleList = new ArrayList<>();
    String title;
    int []images1=
            new int[]{R.drawable.tall};

    int []images3= new int[]{R.drawable.eyse};

    int [] images4= new int[]{R.drawable.move1,R.drawable.move2,
            R.drawable.move3,R.drawable.move4,
            R.drawable.move5,R.drawable.move6,
            R.drawable.move7};
    TextView desc;
int []images5={R.drawable.tatemattable};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrticls_show_with_images);

        recyclerView = (RecyclerView) findViewById(R.id.res);
        desc= (TextView) findViewById(R.id.desc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String []titles=getResources().getStringArray(R.array.evolution_titiles);

title=getIntent().getStringExtra("number");
        desc.setText(getIntent().getStringExtra("desc"));
        if(title.equals(titles[0])){
            adapter = new ImagesAdapter(this, images1);
        }
        else if(title.equals(titles[1])){

            adapter = new ImagesAdapter(this, images3);
        }
        else if(title.equals(titles[2])){

            adapter = new ImagesAdapter(this, images4);
        }
        else{

            adapter = new ImagesAdapter(this, images5);
        }



        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(int i) {
        Intent intent=new Intent(AfrticlsShowWithImages.this,ImageZoom.class);
        intent.putExtra("image",i);
        startActivity(intent);
    }

    @Override
    public void onClick(AricleModel m) {

    }


}
