package com.example.colcalendar18;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ExitService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        // Code Snippet Credit https://stackoverflow.com/questions/47849726/do-something-when-app-is-closed
        Log.d("sdsd", "Sdsd");
        super.onTaskRemoved(rootIntent);
        //do something you want before app closes.
        //stop service
        this.stopSelf();
    }
}
