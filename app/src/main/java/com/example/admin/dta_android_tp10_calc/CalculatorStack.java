package com.example.admin.dta_android_tp10_calc;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by admin on 14/06/2017.
 */

public class CalculatorStack {

    private Stack<Integer> stack;

    public CalculatorStack() {

        stack = new Stack<Integer>();
    }

    public void push(Integer currentValue) {

        stack.push(currentValue);
    }

    public Integer pop() {
        if(stack.size() > 0)
            return stack.pop();
        return 0;
    }

    public int size() {
        return stack.size();
    }

    public ArrayList<Integer> swap() throws Exception {
        ArrayList<Integer> result = new ArrayList<Integer>();
        try {
            if(stack.size() > 1) {
                Integer value1 = pop();
                Integer value2 = pop();
                result.add(value1);
                result.add(value2);
                push(value1);
                push(value2);
            }
            else
                throw new Exception("Need at least 2 integers");
        }
        catch(Exception ex) {
            throw ex;
        }
        return result;
    }

    public String plus() throws Exception {
        String result = "";
        try {
            if(stack.size() > 1) {
                Integer left = stack.pop();
                Integer right = stack.pop();
                if(CheckOverflowOnAdd(left, right))
                    throw new Exception("Integer overflow");
                else
                {
                    stack.push(left + right);
                    result =  stack.peek().toString();
                }
            }
            else
                throw new Exception("Need at least 2 integers");
        }
        catch(Exception ex) {
            throw ex;
        }
        return result;
    }

    public String minus() throws Exception {
        String result = "";
        try {
            if(stack.size() > 1) {
                Integer left = stack.pop();
                Integer right = stack.pop();
                if(CheckOverflowOnSubstract(left, right))
                    throw new Exception("Integer overflow");
                else
                {
                    stack.push(left - right);
                    result =  stack.peek().toString();
                }
            }
            else
                throw new Exception("Need at least 2 integers");
        }
        catch(Exception ex) {
            throw ex;
        }
        return result;
    }


    public static boolean CheckOverflowOnAdd(int left, int right) {
        if(right < 0 && right != Integer.MIN_VALUE) {
            return CheckOverflowOnSubstract(left, -right);
        } else {
            return (~(left ^ right) & (left ^ (left + right))) < 0;
        }
    }

    public  static boolean CheckOverflowOnSubstract(int left, int right) {
        if(right < 0) {
            return CheckOverflowOnAdd(left, -right);
        } else {
            return ((left ^ right) & (left ^ (left - right))) < 0;
        }
    }



}
