package com.cs60333.username.lab2_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by bchaudhr on 2/8/2017.
 */

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle os) {
        super.onCreate(os);
        setContentView(R.layout.activity_main);

        final ArrayList<String[]> teams = new ArrayList<>();
        teams.add(new String[]{"fsulg", "Florida State", "Feb 11", "Saturday, February 11, 6:00 PM","Purcell Pavilion at the Joyce Center, Notre Dame, Indiana","(21-5)","74 - 84","Seminoles"});
        teams.add(new String[]{"bclg", "Boston College", "Feb 14", "Tuesday, February 14, 7:00 PM","Silvio O. Conte Forum, Chestnut Hill, Massachusetts","(9-18)","84 - 76","Eagles"});
        teams.add(new String[]{"ncstlg", "North Carolina State", "Feb 18","Saturday, February 18, 12:00 PM","PNC Arena, Raleigh, North Carolina","(14-14)","81 - 72","Wolfpack"});
        teams.add(new String[]{"geotlg", "Georgia Tech", "Feb 26","Sunday, February 26, 6:30 PM","Purcell Pavilion at the Joyce Center, Notre Dame, Indiana","(16-11)","TBD","Yellow Jackets"});
        teams.add(new String[]{"bclg", "Boston College", "March 1","Wednesday, March 1, 8:00 PM","Purcell Pavilion at the Joyce Center, Notre Dame, Indiana","(9-18)","TBD","Eagles"});
        teams.add(new String[]{"loulg", "Louisville", "March 4","Saturday, March 4, 2:00 PM","KFC Yum! Center, Louisville, Kentucky","(22-5)","TBD","Cardinals"});
        teams.add(new String[]{"badge", "ACC Tournament", "March 7","Tuesday, March 7","Barklays Center, Brooklyn, New York", "TBA","TBA"});
        teams.add(new String[]{"badge", "NCAA Tournament", "March 16","Thursday, March 16","TBA","TBA","TBA"});

        ListView scheduleListView = (ListView) findViewById(R.id.lstview_schedule);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this, teams);
        scheduleListView.setAdapter(scheduleAdapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("team", teams.get(position));
                startActivity(detailIntent);
            }
        };
        scheduleListView.setOnItemClickListener (clickListener);
    }
}
