package com.zm.json.service.impl;

import com.zm.json.Exception.ExpressionErrorException;
import com.zm.json.expression.Expression;
import com.zm.json.expression.OperatorEnum;
import com.zm.json.service.Calculate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by zouming on 17-4-13.
 */
public class CalculateImpl implements Calculate {
    @Override
    public Object calculate(String left, String right, OperatorEnum operatorEnum) throws ExpressionErrorException {
        switch (operatorEnum){
            case ADD:return new BigDecimal(Double.valueOf(left)).add(new BigDecimal(Double.valueOf(right)), MathContext.DECIMAL32);
            case SUBSTRACT:return new BigDecimal(Double.valueOf(left)).subtract(new BigDecimal(Double.valueOf(right)), MathContext.DECIMAL32);
            case DIVIDE:return new BigDecimal(Double.valueOf(left)).divide(new BigDecimal(Double.valueOf(right)),MathContext.DECIMAL32);
            case MULTI:return new BigDecimal(Double.valueOf(left)).multiply(new BigDecimal(Double.valueOf(right)), MathContext.DECIMAL32);
            default:return 0;
        }
    }
}
