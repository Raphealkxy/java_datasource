package com.raphael.stack;

import java.util.Scanner;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.stack
 * @date:2019/7/15
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
           //测试一下ArrayStack是否正确
        //先创建一个ArrayStack对象 表示一个栈
      ArrayStack arrayStack=  new ArrayStack(4);
      String key="";
      boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈");//入栈
            System.out.println("pop:表示从栈取出数据");//出栈
            System.out.println("请输入你的选择");
            key =scanner.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("出栈的数据是%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

//定义一个类 ArrayStack 表示栈
class ArrayStack{
    private int maxSize;//栈大小
    private int[] stack;//数组，数组模拟栈，数据放在数组
    private int top =-1;//top表示栈顶，初始化为-1；

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈满 top = maxSize-1 栈满

    public  boolean isFull(){
        return  top==maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top ==-1;
    }

    //入栈 push
    public void push(int value){
        //先判断栈满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈
    public int pop(){
        //将栈顶的数据返回
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈 遍历时需要从栈顶开始显示数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }

        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}