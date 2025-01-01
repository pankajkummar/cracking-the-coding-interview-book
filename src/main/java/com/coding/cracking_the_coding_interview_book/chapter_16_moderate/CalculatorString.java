package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.Stack;

public class CalculatorString {
    public static int calculate(String str){
        Stack<Integer> numbers = new Stack<>();
        Stack<String> operations = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }
            else{
                numbers.add(Integer.parseInt(sb.toString()));
                operations.add(String.valueOf(c));
                sb.setLength(0);

            }
        }
        return 1;
    }
   public static void multiplyAndDivide(Stack<Integer> number ,Stack<String> operation){
        float firstNumber = number.pop();
        Stack<Float> number2 = new Stack<>();
        Stack<String> operation2 = new Stack<>();
        while(!operation.isEmpty()){
            float secondNumber = number.pop();
            String op = operation.pop();
            if(op=="*"){
                Float num = firstNumber*secondNumber;
                number2.add(num);
            }
            if(op=="/"){
                float num = firstNumber/secondNumber;
            }

        }
   }
    public static void main(String[] args) {
        String s = "2*3/5+567+54-3";
        calculate(s);
    }
}
