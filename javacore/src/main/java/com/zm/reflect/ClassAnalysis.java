package com.zm.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;

import static java.lang.System.out;

/**
 * Created by zouming on 17-4-5.
 */
public class ClassAnalysis {

    public static void main(String[]args){
        Class clazz = UserInfo.class;

        out.print(Modifier.toString(clazz.getModifiers()) + " " +  clazz.getName());
        TypeVariable<Class>[] ts = clazz.getTypeParameters();
        for (int i = 0; i < ts.length; i++) {
            if (i == 0) out.print("<");
            if (i>0)out.print(", ");
            out.print(ts[i].getName());
        }
        out.println("> {");
        Field[]fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            out.println(" " + Modifier.toString(fields[i].getModifiers()) + " " + fields[i].getType().getName() + " " + fields[i].getName() + ";");
        }

        Method[]methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            out.print(" " + Modifier.toString(methods[i].getModifiers())
                + " " + methods[i].getGenericReturnType().getTypeName()
//                + " " + methods[i].getReturnType().getName()
                + " " + methods[i].getName() + "(" );
            Parameter[] parameters = methods[i].getParameters();
            for (int p = 0; p < parameters.length; p++) {
                if (p>0){
                    out.print(", ");
                }
                out.print(parameters[p].getParameterizedType().getTypeName() + " " + parameters[p].getName());
            }
            out.print(")");

            Class[]cl = methods[i].getExceptionTypes();
            for (int eIndex=0; eIndex<cl.length; eIndex ++ ) {
                if (eIndex>0){
                    out.print(", ");
                }
                out.print(cl[eIndex].getName());
            }
            out.println("{}");
//            methods[i].getReturnType()
        }

        out.println("}");
    }
}
