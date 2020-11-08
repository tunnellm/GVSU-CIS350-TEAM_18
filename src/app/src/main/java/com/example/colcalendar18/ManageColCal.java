package com.example.colcalendar18;

import android.content.Intent;
import android.os.Bundle;

import com.example.colcalendar18.ui.main.CourseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.colcalendar18.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.Objects;



public class ManageColCal extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignments);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        sectionsPagerAdapter.addFragment(new CourseFragment());
        
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        Intent intent = getIntent();




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.fab) {
                    String tabName = Objects.requireNonNull(tabs.getTabAt(tabs.getSelectedTabPosition())).getText().toString().toLowerCase();
                    String b = "";
                    if (tabName.startsWith("a") || tabName.startsWith("e")) {
                        b = "n ";
                    } else {
                        b = " ";
                    }
                    // Change listener to instantiate class assignment, course, event based on tab selected
                    // Needs to show classes in here
                    Snackbar.make(view, "Add a" + b + tabName.substring(0, tabName.length() - 1), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

    }

}