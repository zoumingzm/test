package com.zm.json.utils;

import com.zm.common.utils.StringUtil;
import com.zm.json.Exception.ExpressionErrorException;
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
                case '+':
                case '-':
                case '*':
                case '(':
                case ')':
                case '/':isAdd=false;assemble(linkedList, temp, String.valueOf(str.charAt(i)));temp="";break;
                default:temp = isAdd ? temp+str.charAt(i) : ""+str.charAt(i);isAdd=true; break;
            }
            if (i == str.length()-1) assemble(linkedList, temp, null);
        }

        out.println(linkedList.toString());
        this.calBrackets(linkedList);//计算括号内
        this.cal(linkedList);//计算剩下的
        out.println(Arrays.toString(linkedList.toArray()));
        return null;
    }

    public void assemble(List<String> stack, String temp, CharSequence c){
        if (StringUtil.isNotEmpty(temp)){
            stack.add(temp);
        }
        if (c!=null && StringUtil.isNotEmpty(c.toString())){
            stack.add(c.toString());
        }
    }

    private void calBrackets(List<String> linkedList) throws Exception{
        int i = 0;//记录遍历位置
        int j = 0;//记录实际位置
        while ( i < linkedList.size()){
            if (")".equals(linkedList.get(i))){
                int start = linkedList.subList(0, i).lastIndexOf("(");//取出匹配的左括号

                List list = new LinkedList<>();
                list.addAll(linkedList.subList(start,i));//临时列表
                list.remove(0);//移除左括号
                if (list.size() == 0){
                    throw new ExpressionErrorException("index " + j + " near error.");
                }
                this.cal(list);//括号优先级最高，因此先计算
                linkedList.subList(start,i+1).clear();//移除当前匹配括号以及其内容

                if (list!=null && !list.isEmpty()) {
                    linkedList.addAll(start, list);//将计算结果插入到start位置
                }
                i = start;//列表长度已改变，从本次计算的start位置开始遍历
            }
            i++;//列表长度未改变，从i+1位置继续遍历
            j++;
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
            getExpression("(1)*(((1+1))+1)/(3*3)");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
