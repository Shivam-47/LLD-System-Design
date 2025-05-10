package org.example.Expressions;

public class Number implements ArithmeticExpression {
    Integer value;

    public Number(Integer value){
        this.value = value;
    }

    @Override
    public int operate() throws Exception {
        return value;
    }
}
