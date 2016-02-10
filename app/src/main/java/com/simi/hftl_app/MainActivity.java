package com.simi.hftl_app;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//TODO Implementierung des Testfragments
//TODO Erstellen eines Menüs
//TODO Links auf die Website einbinden
//TODO Inhalte der Studiengänge eintragen

    private ImageView backButton;
    private boolean isClose;
    private StudyListItem clickedElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hftl_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_color));
        }

        backButton = (ImageView) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final Button study_button = (Button) findViewById(R.id.button_study);
        Button study__dual_button = (Button) findViewById(R.id.button_study_dual);
        Button study_job_button = (Button) findViewById(R.id.button_study_job);
        Button study_test_button = (Button) findViewById(R.id.button_study_test);

        study_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new StudyFragment());
                ft.addToBackStack(StudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });


        study__dual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new DualStudyFragment());
                ft.addToBackStack(DualStudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });


        study_job_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new JobStudyFragment());
                ft.addToBackStack(JobStudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });


        study_test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new TestStudyFragment());
                ft.addToBackStack(TestStudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            backButton.setVisibility(View.INVISIBLE);
            closeActivity();
        }
        else if (getSupportFragmentManager().getBackStackEntryCount() == 1)
        {
            backButton.setVisibility(View.INVISIBLE);
            super.onBackPressed();
        }
        else
        {
            super.onBackPressed();
        }
    }

    public void closeActivity()
    {
        if (!isClose)
        {
            isClose = true;
            Toast.makeText(getApplicationContext(), "Erneut tippen zum Beenden.", Toast.LENGTH_LONG).show();
        }
        else
        {
            MainActivity.this.finish();
        }
    }

    public StudyListItem getClickedElement() {
        return clickedElement;
    }

    public void setClickedElement(StudyListItem clickedElement) {
        this.clickedElement = clickedElement;
    }
}