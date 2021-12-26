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

public class HorizontalProductAdaptor extends RecyclerView.Adapter<HorizontalProductAdaptor.ViewHolder> {

    private List<HorizontalItemModel> list;


    public HorizontalProductAdaptor(List<HorizontalItemModel> list) {
        this.list = list;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_image_layout , parent, false);





        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

        holder.setData(list.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.viewAllGalleryIv);


        }
        public void setData(int imageResource )
        {
            imageView.setImageDrawable(itemView.getResources().getDrawable(imageResource) );

        }

    }
}
