package org.example;

import org.example.Expressions.ArithmeticExpression;
import org.example.Expressions.Expression;
import org.example.Expressions.Number;
import org.example.Expressions.Operator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to calculator solver");

        try {
            //2+4
            ArithmeticExpression left = new Expression(new Number(2), new Number(4), Operator.ADD);
            //3-1
            ArithmeticExpression right = new Expression(new Number(3), new Number(1), Operator.SUBTRACT);

            //(2+4)*(3-1)
            ArithmeticExpression exp = new Expression(left, right, Operator.MULTIPLY);
            System.out.println("exp: " + exp.operate());

            ArithmeticExpression left2 = new Number(2);
            ArithmeticExpression right2 = new Expression(new Number(2), new Number(1), Operator.ADD);
            ArithmeticExpression exp2 = new Expression(left2, right2, Operator.MULTIPLY);
            System.out.println("exp2: " + exp2.operate());


            //((2+4)*(3-1)/(2)*(2+1))
            ArithmeticExpression result = new Expression(exp, exp2, Operator.DIVIDE);
            System.out.println("value: " + result.operate());
        } catch (Exception e){
            System.out.println("Caught Exception " + e.toString());
        }
    }
}