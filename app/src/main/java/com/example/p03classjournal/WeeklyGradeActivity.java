package com.example.p03classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class WeeklyGradeActivity extends AppCompatActivity {
    ListView lvGrade;
    Button btnAdd, btnInfo, btnEmailFaci;

    ArrayAdapter aa;
    ArrayList<DailyCA> CA;

    String moduleCode, email, msgContent;
    int requestCodeForModule = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_grade);

        lvGrade = findViewById(R.id.listViewWeeklyGrade);
        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);
        btnEmailFaci = findViewById(R.id.buttonEmailFaci);

        CA = new ArrayList<>();

        DailyCA w1 = new DailyCA("B", "C347", 1);
        CA.add(w1);
        DailyCA w2 = new DailyCA("C", "C347", 2);
        CA.add(w2);
        DailyCA w3 = new DailyCA("A", "C347", 3);
        CA.add(w3);

        final Intent moduleIntent = getIntent();

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        moduleCode = moduleIntent.getStringExtra("module");
        email = moduleIntent.getStringExtra("email");
        setTitle("Info for " + moduleCode);

        aa = new GradeAdapter(this, R.layout.row_module_info, CA);
        lvGrade.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRP = new Intent(Intent.ACTION_VIEW);
                intentRP.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));

                startActivity(intentRP);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(getBaseContext(), AddGradeActivity.class);
                addIntent.putExtra("weekNum", CA.size() + 1);
                startActivityForResult(addIntent, requestCodeForModule);
            }
        });

        btnEmailFaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Daily Grade for " + moduleCode);

                msgContent = "Hi Faci \n\nI am ... \nPlease see my remarks so far, thank you!";
                emailIntent.putExtra(Intent.EXTRA_TEXT, msgContent);

                emailIntent.setType("message/rfc822");

                startActivity(Intent.createChooser(emailIntent, "Choose an Email Client:"));
            }
        });
    }
}
