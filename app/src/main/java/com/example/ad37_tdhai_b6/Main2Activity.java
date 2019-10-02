package com.example.ad37_tdhai_b6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    TextView tvDate, tvHour, tvTag, tvWeekDay;
    Button btTune;
    Spinner spinner;
    ImageView imageView;
    ArrayList<String> item;
    Calendar calendar;
    int ngay;
    int thang;
    int nam;
    int gio;
    int phut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvDate = findViewById(R.id.tvDate);
        tvHour = findViewById(R.id.tvHour);
        tvTag = findViewById(R.id.tvTag);
        tvWeekDay = findViewById(R.id.tvWeekday);
        btTune = findViewById(R.id.btTune);
        spinner = findViewById(R.id.spSpinner);
        imageView = findViewById(R.id.im3cham);

        calendar=Calendar.getInstance();
        ngay=calendar.get(Calendar.DAY_OF_MONTH);
        thang=calendar.get(Calendar.MONTH);
        nam=calendar.get(Calendar.YEAR);
        gio=calendar.get(Calendar.HOUR_OF_DAY);
        phut=calendar.get(Calendar.MINUTE);



       tvHour.setText(String.valueOf(gio)+":"+String.valueOf(phut));
       tvHour.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               showDialogTime();
           }
       });

       tvDate.setText((String.valueOf(ngay)+"/"+String.valueOf(thang)+"/"+String.valueOf(nam)));
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogDate();
            }
        });


        item = new ArrayList<>();
        item.add("Work");
        item.add("Friend");
        item.add("Family");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, item);
        spinner.setAdapter(arrayAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.contac_menu,
                        popupMenu.getMenu());
                popupMenu.show();
            }
        });

        tvWeekDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                boolean[] isChecks = {false, true, false, true, false, false, true};

                AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this)
                        .setTitle("Select Group")
                        .setMultiChoiceItems(weekdays, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                alertDialog.show();
            }
        });

        tvTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] tags = {"Family", "Android", "Game", "VTC", "Friend"};
                boolean[] isChecks = {false, true, false, true, false, false, true};

                AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this)
                        .setTitle("Select Group")
                        .setMultiChoiceItems(tags, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                alertDialog.show();
            }
        });

        btTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_tune,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.Fromfile:
                                Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.Fromdefault:
                                String[] tunes = {"Bài hát 1", "Bài hát 2", "Bài hát 3"};
                                AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this)
                                        .setTitle("Choose RingTune")
//                        .setMessage("SetMessenger")
                                        .setSingleChoiceItems(tunes, 1, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        })
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .create();

                                alertDialog.show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });


    }
    public void showDialogTime(){
        TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

            }
        }, gio, phut, true);
        timePickerDialog.show();
    }

    public void showDialogDate(){
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        }, ngay, thang, nam);
        datePickerDialog.show();
    }
}
