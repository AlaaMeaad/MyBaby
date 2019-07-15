package com.rqeeqa.mybaby.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rqeeqa.mybaby.R;
import com.rqeeqa.mybaby.interfaces.Communication;
import com.rqeeqa.mybaby.models.CatModel;

import java.util.List;

/**
 * Created by melde on 8/20/2017.
 */

public class DepartAdapter extends RecyclerView.Adapter<DepartAdapter.ViewHolder> {
    private Context context;

    Communication con;

    List<CatModel> list;

    public DepartAdapter(Context c, List<CatModel> catList) {

        this.context = c;

list=catList;
    }

    @Override
    public DepartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        DepartAdapter.ViewHolder holder = new DepartAdapter.ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(DepartAdapter.ViewHolder holder, int position) {
       holder.name.setText(list.get(position).getName());

        holder.logo.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;

        ImageView logo;

        public ViewHolder(View itemView) {
            super(itemView);

          name = (TextView) itemView.findViewById(R.id.name);
            logo= (ImageView) itemView.findViewById(R.id.logo);
            con = (Communication) context;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            con.onClick(adapterPosition);

        }
    }}