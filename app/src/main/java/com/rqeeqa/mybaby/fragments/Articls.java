package com.rqeeqa.mybaby.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rqeeqa.mybaby.R;
import com.rqeeqa.mybaby.adapters.ArticleAdapter;
import com.rqeeqa.mybaby.helper;
import com.rqeeqa.mybaby.models.AricleModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Articls extends Fragment {


    public Articls() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    ArticleAdapter adapter;
    List<AricleModel> articleList = new ArrayList<>();

    List<AricleModel> list=new ArrayList<>();

    String[] titles;
    String[] descs;
int []tarbea_imagee={R.drawable.tarbea1,R.drawable.tarbea2,R.drawable.tarbea3,
        R.drawable.tarbea4,R.drawable.tarbea5,R.drawable.tarbea6,
        R.drawable.tarbea2,R.drawable.tarbea8,R.drawable.tarbea10,
        R.drawable.tarbea9,R.drawable.tarbea11};
    int [] commom_question_image={R.drawable.commonquestion1,
            R.drawable.commonquestion2,R.drawable.commonquestion3,
            R.drawable.commonquestion4,R.drawable.commonquestion5,
            R.drawable.commonquestion6,R.drawable.commonquestion7,
            R.drawable.commonquestion91,R.drawable.commonquestion9,
            R.drawable.commonquestion10};
    int []diseases_image={R.drawable.diseas1,R.drawable.diseas2,
            R.drawable.diseas3,R.drawable.diseas4};
    int []month_image={R.drawable.month1,R.drawable.month2,
            R.drawable.month3,R.drawable.month4,
            R.drawable.month5,R.drawable.month6,R.drawable.month7,R.drawable.month8};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articls, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.res);


        int t = -1,s=3;

        if (getArguments() != null) {
            t = getArguments().getInt("type");
            switch (t) {
                case -1:
                    articleList.add((AricleModel) getArguments().getSerializable("model"));

                    if(new helper(getActivity()).isOnline())
                    {
                        int p=0;
                        s=articleList.size()/3;
                        for(int j=0;j<articleList.size()+s;j++) {
                            if (j != 0 && j % 3 == 0) {
                                list.add(new AricleModel());
                            } else {
                                list.add(articleList.get(p));
                                p++;
                            }
                        }

                    }
                    break;
                case 1:
                    titles = getResources().getStringArray(R.array.tabe3y_titles);
                    descs = getResources().getStringArray(R.array.tabe3y_desc);
                    for (int i = 0; i < titles.length; i++) {
                        AricleModel m = new AricleModel();
                        m.setTitle(titles[i]);
                        m.setDesc(descs[i]);
                        m.setImage(0);
                        articleList.add(m);
                    }
                    if(new helper(getActivity()).isOnline())
                    {
                        int p=0;
                    s=articleList.size()/3+1;
                    for(int j=0;j<articleList.size()+s;j++) {
                        if (j != 0 && j % 3 == 0) {
                            list.add(new AricleModel());
                        } else {
                            list.add(articleList.get(p));
                            p++;
                        }
                    }

                    }
                    break;
                case 2:
                    titles = getResources().getStringArray(R.array.tarbya_title);

                    descs = getResources().getStringArray(R.array.tarbea_desc);
                    for (int i = 0; i <titles.length; i++) {
                        AricleModel m = new AricleModel();

                        m.setTitle(titles[i]);
                        m.setDesc(descs[i]);
                        m.setImage(tarbea_imagee[i]);
                        articleList.add(m);

                    }
                    if(new helper(getActivity()).isOnline())
                    {   int p=0;
                        s=articleList.size()/3+1;
                        for(int j=0;j<articleList.size()+s;j++) {
                            if (j != 0 && j % 3 == 0) {
                                list.add(new AricleModel());
                            } else {
                                list.add(articleList.get(p));
                                p++;
                            }
                        }

                    }
                    break;
                 case 3:
                    titles = getResources().getStringArray(R.array.common_questions_titles);

                    descs = getResources().getStringArray(R.array.common_questions_desc);
                    for (int i = 0; i < titles.length; i++) {
                        AricleModel m = new AricleModel();
                        m.setTitle(titles[i]);
                        m.setDesc(descs[i]);
                        m.setImage(commom_question_image[i]);
                        articleList.add(m);
                    } if(new helper(getActivity()).isOnline())
                 {
                     int p=0;
                     s=articleList.size()/3+1;
                     for(int j=0;j<articleList.size()+s;j++) {
                         if (j != 0 && j % 3 == 0) {
                             list.add(new AricleModel());
                         } else {
                             list.add(articleList.get(p));
                             p++;
                         }
                     }

                 }
                     break;
                case 4:
                    titles = getResources().getStringArray(R.array.disease_titles);

                    descs = getResources().getStringArray(R.array.diseases_desc);
                    for (int i = 0; i < titles.length; i++) {
                        AricleModel m = new AricleModel();
                        m.setTitle(titles[i]);
                        m.setDesc(descs[i]);
                        m.setImage(diseases_image[i]);
                        articleList.add(m);
                    } if(new helper(getActivity()).isOnline())
                {
                    int p=0;
                    s=articleList.size()/3;
                    for(int j=0;j<articleList.size()+s;j++) {
                        if (j != 0 && j % 3 == 0) {
                            list.add(new AricleModel());
                        } else {
                            list.add(articleList.get(p));
                            p++;
                        }
                    }

                }
                    break;
                case 5:
                    titles = getResources().getStringArray(R.array.evolution_titiles);

                    descs = getResources().getStringArray(R.array.evolution_desc);
                    for (int i = 0; i < titles.length; i++) {
                        AricleModel m = new AricleModel();
                        m.setTitle(titles[i]);
                        m.setDesc(descs[i]);
                        if(i==3){
                        m.setImage(R.drawable.talk);}
                        articleList.add(m);
                    }
                    if(new helper(getActivity()).isOnline())
                {
                    int p=0;
                    s=articleList.size()/3;
                    for(int j=0;j<articleList.size()+s;j++) {
                        if (j != 0 && j % 3 == 0) {
                            list.add(new AricleModel());
                        } else {
                            list.add(articleList.get(p));
                            p++;
                        }
                    }

                }
                    break;

                case 50:
                    titles = getResources().getStringArray(R.array.months_titles);

                    descs = getResources().getStringArray(R.array.month_desc);
                    for (int i = 0; i < titles.length; i++) {
                        AricleModel m = new AricleModel();
                        m.setTitle(titles[i]);
                        m.setDesc(descs[i]);
                        m.setImage(month_image[i]);
                        articleList.add(m);
                    }if(new helper(getActivity()).isOnline())
                {
                    int p=0;
                    s=articleList.size()/3+1;
                    for(int j=0;j<articleList.size()+s;j++) {
                        if (j != 0 && j % 3 == 0) {
                            list.add(new AricleModel());
                        } else {
                            list.add(articleList.get(p));
                            p++;
                        }
                    }

                }
                    break;

            }
        }



        // recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if(new helper(getActivity()).isOnline()) {
            adapter = new ArticleAdapter(getActivity(), list);
        }
        else {
            adapter = new ArticleAdapter(getActivity(), articleList);

        }
        recyclerView.setAdapter(adapter);

        return view;
    }
}


