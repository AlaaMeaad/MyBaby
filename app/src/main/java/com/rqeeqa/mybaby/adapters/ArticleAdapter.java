package com.rqeeqa.mybaby.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rqeeqa.mybaby.R;
import com.rqeeqa.mybaby.helper;
import com.rqeeqa.mybaby.interfaces.Communication;
import com.rqeeqa.mybaby.models.AricleModel;

import java.util.List;

/**
 * Created by melde on 8/20/2017.
 */

public class ArticleAdapter   extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

     List<AricleModel>list;

    Communication con;
    int i=0;
    public ArticleAdapter(Context c, List<AricleModel> articleList) {

        this.context = c;
        list=articleList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


         View row = null;
        if(!new helper(context).isOnline()){
            row = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
            return new ViewHolderArticle(row);

        }
        else {
            switch (viewType) {
                case 0:
                    row = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
                    return new ViewHolderArticle(row);

                case 3:
                    row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_item, parent, false);
                    return new ViewHolderAds(row);

                case 6:
                    row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_item2, parent, false);
                    return new ViewHolderAds(row);

                case 9:
                    row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_item3, parent, false);
                    return new ViewHolderAds(row);
                case 12:
                    row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_item4, parent, false);
                    return new ViewHolderAds(row);

                default:
                    row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_item4, parent, false);
                    return new ViewHolderAds(row);

            }
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
if(getItemViewType(position)==0) {
    ViewHolderArticle viewholder = (ViewHolderArticle) holder;
    viewholder.title.setText(list.get(position).getTitle());
    viewholder.desc.setText(list.get(position).getDesc());
    try {
        if(list.get(position).getImage()==new AricleModel().getImage()){

            viewholder.logo.setImageResource(R.drawable.articles);
        }
        else {
            viewholder.logo.setImageResource(list.get(position).getImage());
        }
    }
    catch (NullPointerException e){
        viewholder.logo.setImageResource(R.drawable.articles);}
    catch (OutOfMemoryError e){}
}
else {
    ViewHolderAds viewholder = (ViewHolderAds) holder;
    //viewholder.
            AdRequest adRequest = new AdRequest.Builder().build();
    viewholder.mAdView.loadAd(adRequest);

}
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(position%3==i&&position!=0&&new helper(context).isOnline()){
            return  position;
        }
       // else if(position%3==1&&position!=1){return -1;}
        else {
            return 0;//chatModelList.get(position).getType();
        }
    }
    class ViewHolderAds extends RecyclerView.ViewHolder {

AdView mAdView;

        public ViewHolderAds(View itemView) {
            super(itemView);
            mAdView= (AdView) itemView.findViewById(R.id.adView2);

        }

    }

    class ViewHolderArticle extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView title,desc;
ImageView logo;
        public ViewHolderArticle(View itemView) {
            super(itemView);
           title = (TextView) itemView.findViewById(R.id.title);
            logo= (ImageView) itemView.findViewById(R.id.logo);
            desc = (TextView) itemView.findViewById(R.id.desc);
            con = (Communication) context;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            con.onClick(list.get(getAdapterPosition()));
        }
    }

}