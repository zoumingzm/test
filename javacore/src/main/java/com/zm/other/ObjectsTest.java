package com.zm.other;

import org.junit.Test;

import java.util.Objects;
import static java.lang.System.out;

/**
 * Created by zouming on 17-4-20.
 */
public class ObjectsTest {

    @Test
    public void testEquals(){
        Object obj = 1l;
        Long l = 1l;

        out.println(Objects.equals(obj,l));
    }
}
