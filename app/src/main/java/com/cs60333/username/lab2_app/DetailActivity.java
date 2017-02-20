package com.cs60333.username.lab2_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by user on 2/20/2017.
 */

public class DetailActivity extends Activity {
    @Override
    public void onCreate(Bundle os) {
        super.onCreate(os);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String[] teams = intent.getStringArrayExtra("team");

        ImageView teamLogo1 = (ImageView) findViewById(R.id.teamLogo1);
        String mDrawableName = teams[0];
        int resID = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
        teamLogo1.setImageResource(resID );

        ImageView teamLogo2 = (ImageView) findViewById(R.id.teamLogo2);
        teamLogo2.setImageResource(R.drawable.ndlogo);

        TextView team1Name = (TextView) findViewById(R.id.team1Text);
        team1Name.setText(teams[1]);
        TextView team2Name = (TextView) findViewById(R.id.team2Text);
        team2Name.setText("Notre Dame");

        TextView matchDate = (TextView) findViewById(R.id.timeText);
        matchDate.setText(teams[3]);

        TextView matchLoc = (TextView) findViewById(R.id.locText);
        matchLoc.setText(teams[4]);

        TextView team1Record = (TextView) findViewById(R.id.team1Record);
        team1Record.setText(teams[5]);
        TextView team2Record = (TextView) findViewById(R.id.team2Record);
        team2Record.setText("(21-7)");

        TextView score = (TextView) findViewById(R.id.scoreText);
        score.setText(teams[6]);

        TextView team1Mascot = (TextView) findViewById(R.id.team1Mascot);
        team1Mascot.setText(teams[7]);

        TextView team2Mascot = (TextView) findViewById(R.id.team2Mascot);
        team2Mascot.setText("Fighting Irish");


        Button camera = (Button)findViewById(R.id.cameraButton);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        };

        camera.setOnClickListener(clickListener);


    }
}
