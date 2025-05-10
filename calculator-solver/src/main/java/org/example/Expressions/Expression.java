package org.example.Expressions;

public class Expression implements ArithmeticExpression{

    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;

    public Operator operator;

    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operator operator){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int operate() throws Exception {
        try {
            switch (operator) {
                case ADD:
                    return leftExpression.operate() + rightExpression.operate();
                case SUBTRACT:
                    return leftExpression.operate() - rightExpression.operate();
                case MULTIPLY:
                    return leftExpression.operate() * rightExpression.operate();
                case DIVIDE:
                    return leftExpression.operate() / rightExpression.operate();
                default:
                    return 0;
            }
        } catch (Exception e){
            throw new Exception(String.format("Error occurred in evaluating expression: " + e.toString()));
        }
    }
}
