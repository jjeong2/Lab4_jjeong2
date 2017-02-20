package com.cs60333.username.lab2_app;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bchaudhr on 2/8/2017.
 */


public class ScheduleAdapter extends ArrayAdapter<String[]> {

    ScheduleAdapter (Context context, ArrayList<String[]> schedule) {
        super(context, R.layout.schedule_row, schedule);

    }

    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_row, parent, false);
        String[] matchItem = getItem(position);

        ImageView teamLogo = (ImageView) scheduleView.findViewById(R.id.teamLogo);
        String mDrawableName = matchItem[0];
        int resID = getContext().getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        teamLogo.setImageResource(resID );

        TextView teamName = (TextView) scheduleView.findViewById(R.id.teamText);
        teamName.setText(matchItem[1]);

        TextView matchDate = (TextView) scheduleView.findViewById(R.id.scheduleText);
        matchDate.setText(matchItem[2]);

        return scheduleView;
    }

    private String getPackageName() {
        return "com.cs60333.username.lab2_app";
    }
}

