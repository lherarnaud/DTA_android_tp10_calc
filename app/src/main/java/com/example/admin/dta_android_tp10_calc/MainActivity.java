package com.example.admin.dta_android_tp10_calc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends Tracer implements View.OnClickListener {

    private CalculatorStack rpnCalculator;

    int[] buttons =  new int[] {
            R.id.ctl_btn_backspace,
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

    ArrayList<TextView> ctl_stackView;
    private Stack<String> stackHiddenValues;
    private TextView ctl_txt_currentValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctl_txt_currentValue = (TextView) findViewById(R.id.ctl_txt_currentValue);

        // Init calculator and current value
        rpnCalculator = new CalculatorStack();

        // Store stack textviews in a array for updating values
        ctl_stackView = new ArrayList<>();
        ctl_stackView.add((TextView) findViewById(R.id.ctl_txt_stack1));
        ctl_stackView.add((TextView) findViewById(R.id.ctl_txt_stack2));
        ctl_stackView.add((TextView) findViewById(R.id.ctl_txt_stack3));
        ctl_stackView.add((TextView) findViewById(R.id.ctl_txt_stack4));
        stackHiddenValues = new Stack<>();

        // Attach main listener to buttons
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
                writeDigit(1);
                break;

            case R.id.ctl_btn_2:
                writeDigit(2);
                break;

            case R.id.ctl_btn_3:
                writeDigit(3);
                break;

            case R.id.ctl_btn_4:
                writeDigit(4);
                break;

            case R.id.ctl_btn_5:
                writeDigit(5);
                break;

            case R.id.ctl_btn_6:
                writeDigit(6);
                break;

            case R.id.ctl_btn_7:
                writeDigit(7);
                break;

            case R.id.ctl_btn_8:
                writeDigit(8);
                break;

            case R.id.ctl_btn_9:
                writeDigit(9);
                break;

            case R.id.ctl_btn_backspace:
                removeDigit();
                break;

            case R.id.ctl_btn_plus:
                Log.d("Click action math", "PLUS");
                try {
                    String result = rpnCalculator.plus();
                    popValueOnStackView();
                    popValueOnStackView();
                    pushValueOnStackView(result);
                    setCurrentValue("");
                }
                catch(Exception ex) {
                    notify(ex.getMessage());
                }
                break;

            case R.id.ctl_btn_minus:
                Log.d("Click action math", "MINUS");
                try {
                    String result = rpnCalculator.minus();
                    popValueOnStackView();
                    popValueOnStackView();
                    pushValueOnStackView(result);
                    setCurrentValue("");
                }
                catch(Exception ex) {
                    notify(ex.getMessage());
                }
                break;

            case R.id.ctl_btn_divide:
                Log.d("Click action math", "DIVIDE");
                break;

            case R.id.ctl_btn_clear:
                Log.d("Click action stack", "CLEAR");
                rpnCalculator.clear();
                clearOnStackView();
                break;

            case R.id.ctl_btn_pop:
                Log.d("Click action stack", "POP");
                try {
                    popValue();
                } catch (Exception ex) {
                    notify(ex.getMessage());
                }
                break;

            case R.id.ctl_btn_swap:
                Log.d("Click action stack", "SWAP");
                try {
                    ArrayList<Integer> values = rpnCalculator.swap();
                    popValueOnStackView();
                    popValueOnStackView();
                    pushValueOnStackView(String.valueOf(values.get(0)));
                    pushValueOnStackView(String.valueOf(values.get(1)));
                } catch (Exception ex) {
                    notify(ex.getMessage());
                }
                break;

            case R.id.ctl_btn_enter:
                Log.d("Click action stack", "ENTER");
                String currentValue = getCurrentValue();
                try {
                    int newValue = Integer.parseInt(currentValue);
                    pushValue(newValue);
                    setCurrentValue("");
                } catch (NumberFormatException e) {
                    notify("Not a number !");
                }
                break;

            default:
                break;
        }
    }

    //--- REGION STACK OPERATIONS

    private Integer popValue() throws Exception {
        Integer value = rpnCalculator.pop();
        popValueOnStackView();
        return value;
    }

    private void pushValue(Integer newValue) {
        rpnCalculator.push(newValue);
        pushValueOnStackView(String.valueOf(newValue));
    }

    //--- REGION STACK VIEW

    private void pushValueOnStackView(String newValue) {
        TextView olderItem, newerItem = null;

        olderItem = ctl_stackView.get(ctl_stackView.size()-1);
        stackHiddenValues.push(olderItem.getText().toString());

        for(int i = ctl_stackView.size()-2; i >= 0; i--)
        {
            newerItem = ctl_stackView.get(i);
            Log.d("copy '", newerItem.getText()+"' in object #'"+ olderItem.getId()+"'");
            olderItem.setText(newerItem.getText());
            olderItem = newerItem;
        }
        Log.d("copy '", newValue +"' to newest item");
        newerItem.setText(newValue);
    }

    private void popValueOnStackView() {
        TextView olderItem = null, newerItem;

        newerItem = ctl_stackView.get(0);
        for(int i = 1; i < ctl_stackView.size(); i++)
        {
            olderItem = ctl_stackView.get(i);
            Log.d("copy '", olderItem.getText()+"' in object #'"+ newerItem.getId()+"'");
            newerItem.setText(olderItem.getText());
            newerItem = olderItem;
        }

        String stackHiddenValue = (stackHiddenValues.isEmpty()) ? "" : stackHiddenValues.pop();
        Log.d("copy '", stackHiddenValue +"' to oldest item");
        olderItem.setText(stackHiddenValue);
    }

    private void clearOnStackView() {
        TextView textItem;

        stackHiddenValues.clear();
        for(int i = 0; i < ctl_stackView.size(); i++)
        {
            textItem = ctl_stackView.get(i);
            textItem.setText("");
        }
    }


    //--- REGION CURRENT VALUE

    private void writeDigit(int digit) {
        Log.d("Write digit", String.valueOf(digit));
        String newValue = getCurrentValue();
        if(newValue.equals("0"))
            newValue = ""+digit;
        else
            newValue += digit;
        try {
            int result = Integer.parseInt(newValue);
            setCurrentValue(newValue);
        } catch (NumberFormatException e) {
            notify("Not a valid number !");
        }
    }

    private void removeDigit() {
        String newValue = getCurrentValue();
        if(newValue.length() > 1)
            newValue = newValue.substring(0, newValue.length()-1);
        else
            newValue = "0";
        Log.d("Remove digit", "new value : '"+newValue+"'");
        try {
            int result = Integer.parseInt(newValue);
            setCurrentValue(newValue);
        } catch (NumberFormatException e) {
            notify("Not a valid number !");
        }
    }

    private String getCurrentValue() {

        return ctl_txt_currentValue.getText().toString();
    }

    private void setCurrentValue(String newValue) {

        ctl_txt_currentValue.setText(newValue);
    }

}
