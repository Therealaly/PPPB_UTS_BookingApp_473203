package com.example.hotelbookingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotelDataAdapter extends RecyclerView.Adapter<HotelDataAdapter.ViewHolder> {

    HotelData[] hotelData;
    Context context;

    public HotelDataAdapter(HotelData[] hotelData, searchResult activity) {
        this.hotelData = hotelData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.hotel_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HotelData hotelDataList = hotelData[position];
        holder.textViewName.setText(hotelDataList.getHotelName());
        holder.textViewPrice.setText(hotelDataList.getHotelPrice());
        holder.hotelImage.setImageResource(hotelDataList.getHotelImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("image_src", hotelDataList.getHotelImg());
                intent.putExtra("image_name", hotelDataList.getHotelName());
                intent.putExtra("image_price", hotelDataList.getHotelPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView hotelImage;
        TextView textViewName;
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelImage = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.hotel_name);
            textViewPrice = itemView.findViewById(R.id.hotel_price);

        }
    }

}
