package com.example.sarvasva.app.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarvasva.R;

import java.util.List;

public class ViewAllAdaptor extends RecyclerView.Adapter<ViewAllAdaptor.ViewHolder> {

    private List<ViewAllModel> list;
    private ImageView imgView;


    public ViewAllAdaptor(List<ViewAllModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_slider_layout, parent, false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setData(list.get(position).getProductImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.viewAllGalleryIv);



        }
        public void setData(int resource )
        {


            imgView.setImageDrawable(itemView.getResources().getDrawable(resource) );

        }
    }











}
