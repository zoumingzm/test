package com.zm.json.expression;

/**
 * Created by zouming on 17-4-13.
 */
public class Expression {

    private Object result;

    private Expression left;

    private Expression right;

    private String value;

    private OperatorEnum operatorEnum;

    public Expression(CharSequence a){
        this.value = a.toString();
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OperatorEnum getOperatorEnum() {
        return operatorEnum;
    }

    public void setOperatorEnum(OperatorEnum operatorEnum) {
        this.operatorEnum = operatorEnum;
    }
}
