package com.zm.exception;


import org.junit.Test;

import java.sql.SQLDataException;

/**
 * Created by zouming on 17-4-5.
 */
public class InitCauseTest {

    @Test
    public void test() throws Exception{
        try{
            IllegalStateException illegalStateException = new IllegalStateException("传递");
            throw illegalStateException;
        }catch (Exception e){
            SQLDataException sqlDataException = new SQLDataException("final");
            sqlDataException.initCause(e);
            throw sqlDataException;
        }
    }
}
