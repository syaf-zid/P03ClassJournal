package com.example.p03classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddGradeActivity extends AppCompatActivity {
    TextView tvWeekNum;
    RadioGroup rg;
    Button btnSubmit;

    String grade;
    int weekNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);

        tvWeekNum = findViewById(R.id.textViewAddWeek);
        rg = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.buttonSubmit);

        Intent intent = getIntent();
        weekNum = intent.getIntExtra("weekNum", 0);

        tvWeekNum.setText("Week " + weekNum);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setTitle("Add Data for Week " + weekNum);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
                grade = rb.getText().toString();

                DailyCA newGrade = new DailyCA(grade, "C347", weekNum);
                Intent addIntent = new Intent();
                addIntent.putExtra("newGrade", newGrade);
                setResult(RESULT_OK, addIntent);
                finish();
            }
        });
    }
}
