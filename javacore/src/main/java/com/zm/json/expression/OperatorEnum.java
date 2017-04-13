package com.zm.json.expression;

public enum OperatorEnum{
        ADD("+"),
        SUBSTRACT("-"),
        DIVIDE("/"),
        MULTI("*");
    private String label;
    OperatorEnum(String label){
        this.label = label;
    }

    public static OperatorEnum getOperatorEnum(String label){
        for (OperatorEnum operatorEnum : OperatorEnum.values()){
            if (operatorEnum.getLabel().equals(label))return operatorEnum;
        }
        return  null;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static void main(String[] args){
        System.out.println(OperatorEnum.getOperatorEnum("+"));
    }
}
