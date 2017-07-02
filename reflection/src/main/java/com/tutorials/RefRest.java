package com.tutorials;

/**
 * Created by zengpeng on 2017/4/23.
 */
public class RefRest {

    public void test(int in) {

    }

    public static void main(String... args) throws NoSuchMethodException {

        Class t = RefRest.class;

        System.out.print(t.getDeclaredMethod("test", Integer.class));

    }


}
