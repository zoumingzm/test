package com.zm.mybatis.moredatasource;

import java.util.Objects;

/**
 * Created by zouming on 17-4-5.
 */
public class DbContextHolder {

    public enum DbType{
        MASTER,
        SLAVE;
    }

    private final static ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

    public static void setDbType(DbType dbType){
        contextHolder.set(Objects.requireNonNull(dbType));
    }

    public static DbType getDbType(){
        return Objects.isNull(contextHolder.get())?DbType.MASTER:contextHolder.get();
    }

    public static void clearDbType(){
        contextHolder.remove();
    }
}
