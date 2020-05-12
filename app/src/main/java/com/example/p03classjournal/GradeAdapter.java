package com.example.p03classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<DailyCA> {
    private ArrayList<DailyCA> dailyGrade;
    private Context context;
    private TextView tvWeek, tvGrade;
    private ImageView imageView;

    public GradeAdapter(Context context, int resource, ArrayList<DailyCA> objects) {
        super(context, resource, objects);

        dailyGrade = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_module_info, parent, false);

        tvGrade = rowView.findViewById(R.id.textViewGrade);
        tvWeek = rowView.findViewById(R.id.textViewWeek);
        imageView = rowView.findViewById(R.id.imageView);

        DailyCA currDG = dailyGrade.get(position);
        tvWeek.setText("Week " + currDG.getWeek());
        tvGrade.setText(currDG.getDgGrade());
        imageView.setImageResource(R.drawable.dg);

        return rowView;
    }
}
