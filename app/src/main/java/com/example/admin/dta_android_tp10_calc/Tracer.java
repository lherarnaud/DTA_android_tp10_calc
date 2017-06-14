package com.example.admin.dta_android_tp10_calc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by admin on 14/06/2017.
 */

public class Tracer extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //notify("onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //notify("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //notify("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //notify("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //notify("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }

    public void notify(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
