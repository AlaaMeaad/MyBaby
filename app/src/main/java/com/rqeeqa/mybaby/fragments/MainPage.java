package com.rqeeqa.mybaby.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rqeeqa.mybaby.R;
import com.rqeeqa.mybaby.adapters.DepartAdapter;
import com.rqeeqa.mybaby.models.CatModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPage extends Fragment {


    public MainPage() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    DepartAdapter adapter;

    List<CatModel> catList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main_page, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.res);
        if(getArguments()!=null){
            CatModel m=(CatModel) getArguments().getSerializable("cat");

            catList.add((CatModel) getArguments().getSerializable("cat"));
        }
       else{ CatModel catModel=new CatModel();
        catModel.setName("تغذية الطفل");
        catModel.setImage(R.drawable.a);
        catList.add(catModel);


        CatModel catModel2=new CatModel();
        catModel2.setName("الرضاعة");
        catModel2.setImage(R.drawable.tabe3y);
        catList.add(catModel2);


            CatModel catModel3=new CatModel();
            catModel3.setName("التربية السليمة");
            catModel3.setImage(R.drawable.study);
            catList.add(catModel3);


            CatModel catModel4=new CatModel();
            catModel4.setName("أسئلة شائعة واجاباتها");
            catModel4.setImage(R.drawable.ask);
            catList.add(catModel4);


            CatModel catModel5=new CatModel();
            catModel5.setName("امراض شائعة وعلاجها");
            catModel5.setImage(R.drawable.diseas);
            catList.add(catModel5);


            CatModel catModel6=new CatModel();
            catModel6.setName("تطور ونمو الطفل");
            catModel6.setImage(R.drawable.evolution);
            catList.add(catModel6);


            CatModel catModel7=new CatModel();
            catModel7.setName("جدول تطعيمات");
            catModel7.setImage(R.drawable.tatemat);
            catList.add(catModel7);


            CatModel catModel8=new CatModel();
            catModel8.setName("تطبيقات تهمك");
            catModel8.setImage(R.drawable.apps);
            catList.add(catModel8);


            CatModel catModel9=new CatModel();
            catModel9.setName("عن التطبيق");
            catModel9.setImage(R.drawable.aboutus);
            catList.add(catModel9);


            CatModel catModel10=new CatModel();
            catModel10.setName("مشاركة");
            catModel10.setImage(R.drawable.share);
            catList.add(catModel10);


       }
       recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DepartAdapter(getActivity(),catList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);


        return view;
 }
    public void myFragmentDataFromActivity(int passedDataFromActivity) {

// do your stuff

    }
}
