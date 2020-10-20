package com.example.colcalendar18;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* To-DO changes to all of this, there needs to be formatting for files
* all attributes of all relevant classes need to be able to be formatted
* in something like xml and be able to be read back and instantiated on
* app loading.
*/

public class LoadCourseCatalog {

    private Context context;

    public LoadCourseCatalog(Context context) {
        this.context = context;
    }

    public void readFile() throws IOException {
        FileInputStream fis = new FileInputStream(String.valueOf(context.getAssets().open("course.properties")));
        BufferedReader bfr = new BufferedReader(new InputStreamReader(fis));
    }


}
