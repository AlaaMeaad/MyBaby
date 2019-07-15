package com.rqeeqa.mybaby.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rqeeqa.mybaby.R;
import com.rqeeqa.mybaby.interfaces.Communication;

/**
 * Created by melde on 8/24/2017.
 */

public class ImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    int []list;

    Communication con;
    public ImagesAdapter(Context c, int[] articleList) {

        this.context = c;
        list=articleList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View row = null;
        if (viewType == 0) {
            row = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
            return new ImagesAdapter.ViewHolderArticle(row);

        } else {

            row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_item, parent, false);
            return new ImagesAdapter.ViewHolderAds(row);
        }



    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==0){
            ImagesAdapter.ViewHolderArticle viewholder = (ImagesAdapter.ViewHolderArticle) holder;
try {
    viewholder.image.setImageResource(list[position]);
}catch (OutOfMemoryError e ){}
        }
    }


    @Override
    public int getItemCount() {
        return list.length;
    }

    @Override
    public int getItemViewType(int position) {
        if(position%4==0){
            return  position;
        }
        else {
            return 0;//chatModelList.get(position).getType();
        }
    }
    class ViewHolderAds extends RecyclerView.ViewHolder implements View.OnClickListener {



        public ViewHolderAds(View itemView) {
            super(itemView);
            // recieveMessage = (TextView) itemView.findViewById(R.id.recieveMessage);
            con = (Communication) context;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            con.onClick(getAdapterPosition());
        }

    }

    class ViewHolderArticle extends RecyclerView.ViewHolder implements View.OnClickListener {

ImageView image;

        public ViewHolderArticle(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image2);

            con = (Communication) context;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            con.onClick(list[getAdapterPosition()]);
        }
    }
}
