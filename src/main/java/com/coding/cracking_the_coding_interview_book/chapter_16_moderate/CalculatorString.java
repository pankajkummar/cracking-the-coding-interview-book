package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.Stack;

public class CalculatorString {
    public static float calculate(String str){
        Stack<Float> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c); // Build the number
            } else if (c == ' ') {
                continue; // Ignore spaces
            } else {
                if (sb.length() > 0) {
                    numbers.push(Float.parseFloat(sb.toString()));
                    sb.setLength(0); // Reset StringBuilder
                }

                // Handle operator precedence
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                    float b = numbers.pop();
                    float a = numbers.pop();
                    char op = operations.pop();
                    numbers.push(applyOperator(op, a, b));
                }

                operations.push(c); // Push the current operator
            }
        }

        // Push the last number if any
        if (sb.length() > 0) {
            numbers.push(Float.parseFloat(sb.toString()));
        }
        while(!operations.isEmpty()){
            float b = numbers.pop();
            float a = numbers.pop();
            char op = operations.pop();
            numbers.push(applyOperator(op,a,b));
        }
        return numbers.pop();
    }
   public static float applyOperator(char op ,float a, float b){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return 0;
   }
    private static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }
    public static void main(String[] args) {
        String s = "2*3+5/6*3+15";
        System.out.println(calculate(s));
    }
}
