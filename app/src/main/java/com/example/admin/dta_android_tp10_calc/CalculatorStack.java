package com.example.admin.dta_android_tp10_calc;

import java.util.Stack;

/**
 * Created by admin on 14/06/2017.
 */

public class CalculatorStack {

    private Stack<Integer> stack;

    public CalculatorStack() {
        stack = new Stack<Integer>();
    }

    public void Push(Integer currentValue) {
        stack.push(currentValue);
    }

    public Integer pop() {
        if(stack.size() > 0)
            return stack.pop();
        return 0;
    }

    public String plus() {
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
        finally {
            return result;
        }
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
