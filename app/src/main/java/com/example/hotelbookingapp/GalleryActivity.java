package com.example.hotelbookingapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("image_src") && getIntent().hasExtra("image_name") &&
        getIntent().hasExtra("image_price")){

            int imageSrc = getIntent().getIntExtra("image_src", 1);
            String imageName = getIntent().getStringExtra("image_name");
            String imagePrice = getIntent().getStringExtra("image_price");

            setImage(imageSrc, imageName, imagePrice);
        }
    }

    private void setImage(int imageSrc, String imageName, String imagePrice){

        TextView name = (TextView) findViewById(R.id.image_desc);
        name.setText(imageName);

        TextView price = (TextView) findViewById(R.id.image_price);
        price.setText(imagePrice);

        ImageView image = findViewById(R.id.hotel_image);
        image.setImageResource(imageSrc);


    }
}
