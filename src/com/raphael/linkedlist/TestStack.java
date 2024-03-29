package com.raphael.linkedlist;

import java.util.Stack;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: 演示栈的基本使用
 * @date:2019/7/13
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String>stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        //出栈
        //smith.tom.jack
        while(stack.size()>0){
            System.out.println(stack.pop());//就是将栈顶的数据取出
        }
    }
}
