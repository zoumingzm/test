package com.zm.json.service;

import com.zm.json.Exception.ExpressionErrorException;
import com.zm.json.expression.OperatorEnum;

/**
 * Created by zouming on 17-4-13.
 */
public interface Calculate {
    Object calculate(String left, String right, OperatorEnum operatorEnum) throws ExpressionErrorException;
}
