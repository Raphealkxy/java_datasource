package com.raphael.linkedlist;

import java.util.Stack;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: ��ʾջ�Ļ���ʹ��
 * @date:2019/7/13
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String>stack = new Stack<>();
        //��ջ
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        //��ջ
        //smith.tom.jack
        while(stack.size()>0){
            System.out.println(stack.pop());//���ǽ�ջ��������ȡ��
        }
    }
}
