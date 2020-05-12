package com.example.p03classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> aa;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setTitle("Class Journal");

        listView = findViewById(R.id.listViewModules);

        al = new ArrayList<>();
        al.add("C347");

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, WeeklyGradeActivity.class);
                String module = (String) listView.getItemAtPosition(i);
                intent.putExtra("module", module);
                intent.putExtra("email", "jason_lim@rp.edu.sg");
                startActivity(intent);
            }
        });
    }
}
