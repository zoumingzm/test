package com.zm.json;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2017/3/15.
 */
public class JsonAnalysis {

    public static void main(String[] args){
        String json = "{{'aa':11,'bb':{'cc':{'dd':22}},'ee':{'ff':'33'}}";

        if (json.length() - json.replace("{","").length() != json.length() - json.replace("}","").length()){
         throw new IllegalStateException("expression is error.");
        }
        Stack stack = new Stack();
//        Map result = new HashMap<>();
        analysis(stack, json);

//        System.out.println(":".equals(":"));
        System.out.println(stack);
//        System.out.println(stackParam.pop());
    }

    public static void analysis(Stack stack, String jsonString){

        for (int i = 0; i < jsonString.length(); i++) {

            if(jsonString.charAt(i) == '}'){
                doWithBrackets(stack);
            }else if (jsonString.charAt(i) == ',') {
                doWithBrackets(stack);
                stack.push(',');
            }else {
                stack.push(jsonString.charAt(i));
            }
        }
    }

    public static void doWithBrackets(Stack stack){
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        Map mapValue = new HashMap<>();
        boolean isKey = false;

        while (stack.size()>0){
            Object item = stack.pop();
            boolean isMap = false;
            if (item instanceof Map){
                isMap = true;
            }else {
                item = item.toString();
            }
            if (!isKey && !item.equals(":")){
                if (isMap){
                    mapValue.putAll((Map) item);
                }else {

                    value.insert(0,item);
                }
            }else {
                if (!isKey){
                    isKey = true;
                    continue;
                }
                if ( !item.equals("{") && !item.equals(",")){
                    key.insert(0,item);
                }else {
                    break;
                }
            }
        }

        Map map = new HashMap<>();
        map.put(key,value.length()==0 ? mapValue : value);
        stack.push(map);

    }
}
