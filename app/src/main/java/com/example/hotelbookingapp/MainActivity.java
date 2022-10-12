package com.example.hotelbookingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.txt_username1);
        TextView password = (TextView) findViewById(R.id.txt_password1);

        Button loginbtn = (Button) findViewById(R.id.login_btn1);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("mike@email.com") && password.getText().toString().equals("abc123")){
                    Intent intent = new Intent(MainActivity.this,bookingInfo.class);
                    startActivity(intent);
                }else
                    showAlert();
            }
        });
    }
    private void showAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Cannot Login");
        alertDialog.setMessage("Invalid username or password!");

        alertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();
    }
}