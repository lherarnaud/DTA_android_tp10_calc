package com.example.admin.dta_android_tp10_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] buttons =  new int[] {
            R.id.ctl_btn_1, 
            R.id.ctl_btn_2,
            R.id.ctl_btn_3,
            R.id.ctl_btn_4,
            R.id.ctl_btn_5,
            R.id.ctl_btn_6,
            R.id.ctl_btn_7,
            R.id.ctl_btn_8,
            R.id.ctl_btn_9,
            R.id.ctl_btn_plus,
            R.id.ctl_btn_minus,
            R.id.ctl_btn_divide,
            R.id.ctl_btn_clear,
            R.id.ctl_btn_pop,
            R.id.ctl_btn_swap,
            R.id.ctl_btn_enter
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int buttonId : buttons)
        {
            Button ctl_btn = (Button) findViewById(buttonId);
            ctl_btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ctl_btn_1:
                Log.d("Click digit", "1");
                break;

            case R.id.ctl_btn_2:
                Log.d("Click digit", "2");
                break;

            case R.id.ctl_btn_3:
                Log.d("Click digit", "3");
                break;

            case R.id.ctl_btn_4:
                Log.d("Click digit", "4");
                break;

            case R.id.ctl_btn_5:
                Log.d("Click digit", "5");
                break;

            case R.id.ctl_btn_6:
                Log.d("Click digit", "6");
                break;

            case R.id.ctl_btn_7:
                Log.d("Click digit", "7");
                break;

            case R.id.ctl_btn_8:
                Log.d("Click digit", "8");
                break;

            case R.id.ctl_btn_9:
                Log.d("Click digit", "9");
                break;

            case R.id.ctl_btn_plus:
                Log.d("Click action math", "PLUS");
                break;

            case R.id.ctl_btn_minus:
                Log.d("Click action math", "MINUS");
                break;

            case R.id.ctl_btn_divide:
                Log.d("Click action math", "DIVIDE");
                break;

            case R.id.ctl_btn_clear:
                Log.d("Click action stack", "CLEAR");
                break;

            case R.id.ctl_btn_pop:
                Log.d("Click action stack", "POP");
                break;

            case R.id.ctl_btn_swap:
                Log.d("Click action stack", "SWAP");
                break;

            case R.id.ctl_btn_enter:
                Log.d("Click action stack", "ENTER");
                break;

            default:
                break;
        }
    }
    
}
