package com.example.hotelbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class searchResult extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        // passing data from bookingInfo.java
        Intent intent = getIntent();
        String date = intent.getStringExtra(bookingInfo.DATE);
        String room = intent.getStringExtra(bookingInfo.ROOM);

        TextView TextView1 = (TextView) findViewById(R.id.show_date);
        TextView TextView2 = (TextView) findViewById(R.id.show_room);

        TextView1.setText(date);
        TextView2.setText(room);

        //recycler view
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HotelData[] hotelData = new HotelData[]{
                new HotelData("Apamara Resort", "Rp 678.870", R.drawable.pic1),
                new HotelData("Amanira Hotel and Convention", "Rp 1.200.000", R.drawable.pic2),
                new HotelData("Samakila by ATSON", "Rp 987.785", R.drawable.pic3),
                new HotelData("The Omutel Legina", "Rp 1.401.600", R.drawable.pic4),
                new HotelData("Strum Boutique Hotel", "Rp 1.056.111", R.drawable.pic5),
                new HotelData("Daun Vali Legina Hotel", "Rp 797.425", R.drawable.pic6),
                new HotelData("Farifeld by Marrito Legina Vali", "Rp 678.870", R.drawable.pic7),
                new HotelData("The Sebayang Suite", "Rp 3.005.800", R.drawable.pic8),
                new HotelData("The Sembayang Suite", "Rp 3.005.800", R.drawable.pic8),
        };

        HotelDataAdapter hotelDataAdapter = new HotelDataAdapter(hotelData, searchResult.this);
        recyclerView.setAdapter(hotelDataAdapter);
    }
}