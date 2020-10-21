package com.example.colcalendar18;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* To-DO changes to all of this, there needs to be formatting for files
* all attributes of all relevant classes need to be able to be formatted
* in something like xml and be able to be read back and instantiated on
* app loading.
*/

public class CourseCatalog {

//    private Context context;
//
//    public CourseCatalog(Context context) {
//        this.context = context;
//    }

    public void saveState(String string, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("course.catalog", Context.MODE_PRIVATE));
            outputStreamWriter.write(string);
            outputStreamWriter.close();
            Log.d("string", "t");
        }
        catch (IOException io) {
            Log.d("CourseCatalog", io.toString());
        }
    }

}
