package com.example.hotelbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class bookingInfo extends AppCompatActivity {
    public static final String DATE = "com.example.hotelbookingapp.dates";
    public static final String ROOM = "com.example.hotelbookingapp.room";

    private Button mDatePickerBtn;
    private TextView mShowDateRange;

    private Spinner mRoomSpinner;
    int positionOfSelectedDataFromSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_info);

        mDatePickerBtn = findViewById(R.id.date_picker_btn);
        mShowDateRange = findViewById(R.id.picked_date_range);
        mRoomSpinner = findViewById(R.id.room_spinner);

        //block dates before current date
        CalendarConstraints.Builder calendarConstraintBuilder = new CalendarConstraints.Builder();
        calendarConstraintBuilder.setValidator(DateValidatorPointForward.now());


        //material datepicekr
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select Booking Dates");

        builder.setCalendarConstraints(calendarConstraintBuilder.build());

        final MaterialDatePicker materialDatePicker = builder.build();

        mDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "Date_Picker");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        // now update the selected date preview
                        mShowDateRange.setText(materialDatePicker.getHeaderText());
                    }
                });

        //spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Rooms,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mRoomSpinner.setAdapter(adapter);

        //saving spinner data

        Button search = (Button) findViewById(R.id.search_btn);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = mShowDateRange.getText().toString();
                String room = String.valueOf(mRoomSpinner.getSelectedItem());

                Intent displayIntent = new Intent(bookingInfo.this, searchResult.class);
                displayIntent.putExtra(DATE, date);
                displayIntent.putExtra(ROOM, room);

                if (DATE.equals(null)) {
                    Toast.makeText(bookingInfo.this, "Invalid Dates!",Toast.LENGTH_LONG).show();
                }else
                    startActivity(displayIntent);

            }
        });

    }
}