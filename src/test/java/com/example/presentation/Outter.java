package com.example.presentation;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2023/8/3 17:07
 */
public class Outter {

    private Inner inner = new Inner();

    public Inner getInner(){
        return inner;
    }

    public static class Inner{
        public void printTest(){
            System.out.println("print 1 2 3..");
        }
    }
}
