package com.zm.json.utils;

import com.zm.json.expression.Expression;
import com.zm.json.expression.OperatorEnum;
import com.zm.json.service.Calculate;
import com.zm.json.service.impl.CalculateImpl;
import org.junit.Test;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zouming on 17-4-13.
 */
public class ExpressionAnalysis {

    private Calculate calculate = new CalculateImpl();

    public Expression getExpression(String str) throws Exception{
        List<String> linkedList = new LinkedList<>();
        out.println("orgin:" + str);
        str.replace(""," ");
        out.println("trim after:" + str);
        String temp = "";
        boolean isAdd = true;
        for (int i = 0; i < str.length() ; i++) {
            switch (str.charAt(i)){
                case '+':isAdd=false;
                case '-':isAdd=false;
                case '*':isAdd=false;
                case '(':isAdd=false;
                case ')':isAdd=false;
                case '/':isAdd=false;assemble(linkedList, temp, String.valueOf(str.charAt(i)));break;

                default:temp = isAdd ? temp+str.charAt(i) : ""+str.charAt(i);isAdd=true; break;
            }
            if (i == str.length()-1) assemble(linkedList, temp, null);
        }

        out.println(linkedList.toString());
        this.cal(linkedList);
        out.println(Arrays.toString(linkedList.toArray()));
        return null;
    }

    public void assemble(List<String> stack, String temp, CharSequence c){
        stack.add(temp);
        if (c!=null){
            stack.add(c.toString());
        }
    }

    private void cal(List<String> linkedList) throws Exception{
        cal(linkedList,OperatorEnum.DIVIDE.getLabel());
        cal(linkedList,OperatorEnum.MULTI.getLabel());
        cal(linkedList,OperatorEnum.ADD.getLabel());
        cal(linkedList,OperatorEnum.SUBSTRACT.getLabel());
    }

    private void cal(List<String> linkedList, String type) throws Exception{
        int index;
        while ((index = linkedList.indexOf(type))!=-1){
            String right = linkedList.remove(index+1);
            String mid = linkedList.remove(index);
            String left = linkedList.remove(index-1);
            linkedList.add(index-1, calculate.calculate(left, right, OperatorEnum.getOperatorEnum(mid)).toString());
        }
    }

    @Test
    public void test(){
        try {
            getExpression("1000000+1/6");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
