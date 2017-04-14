package com.zm.java8.optional;

import org.junit.Test;

import java.util.Objects;
import java.util.Optional;
import static java.lang.System.out;

/**
 * Created by zouming on 17-4-14.
 */
public class OptionalSimple {

    @Test
    public void test() throws Throwable{
        Optional empty = Optional.empty();
        Optional test = Optional.of("test");

        out.println(empty.isPresent());
        out.println(test.isPresent());

        out.println(test.get());

        out.println(empty.orElse("is empty."));
        out.println(test.orElse("is empty."));

        empty.ifPresent(v->out.println(v));
        test.ifPresent(v->out.println("ifPresent " + v));

        out.println("\ntest orElseGet " + test.orElseGet(()->"is empty."));
        out.println("empty orElseGet " + empty.orElseGet(()->"is empty."));


        out.println("\ntest filter " + test.filter((v)->v.toString().contains("test")).orElseGet(()->"is empty."));
        out.println("empty filter " + empty.filter((v)->v.toString().contains("test")).orElseGet(()->"is empty."));

        out.println("\ntest map " + test.map((v)->v.toString().contains("test")).orElseGet(()->"is empty."));
        out.println("empty map " + empty.map((v)->v.toString().contains("test")).orElseGet(()->"is empty."));

        out.println("\ntest flatMap " + test.flatMap((v)->Optional.of(v)).orElseGet(()->"is empty."));
        out.println("empty flatMap " + empty.flatMap((v)->Optional.of(v)).orElseGet(()->"is empty."));

        out.println("\ntest orElseThrow " + test.orElseThrow(()->{throw new IllegalStateException("test");}));
//        out.println("empty orElseThrow " + empty.orElseThrow(()->{throw new IllegalStateException("empty");}));

        out.println("\ntest.equals(empty) is " + test.equals(empty));

        out.println("\ntest hashCode " + test.hashCode());
        out.println("\nnew test hashCode " + Optional.ofNullable("test").hashCode());

        out.println("\none hashCode " + Optional.ofNullable(new HashcodeTest("11","22")).hashCode());
        out.println("\nother hashCode " + Optional.ofNullable(new HashcodeTest("11","22")).hashCode());
        out.println("\nequals new HashcodeTest(\"11\",\"22\") " + Optional.ofNullable(new HashcodeTest("11","22")).equals(Optional.ofNullable(new HashcodeTest("11","22"))));

        out.println("\ntest hashCode " + empty.hashCode());

    }


    private class HashcodeTest{
        private String name;
        private String addr;

        public HashcodeTest(String name, String addr){
            this.name = name;
            this.addr = addr;
        }

        public HashcodeTest(){

        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)return false;
            if (!obj.getClass().equals(this.getClass()))return false;
            HashcodeTest other = (HashcodeTest) obj;
            if (Objects.equals(name, other.name) && Objects.equals(addr, other.addr)){
                return true;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name,addr);
        }
    }
}
