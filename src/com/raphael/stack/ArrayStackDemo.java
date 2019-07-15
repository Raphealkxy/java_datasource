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
           //����һ��ArrayStack�Ƿ���ȷ
        //�ȴ���һ��ArrayStack���� ��ʾһ��ջ
      ArrayStack arrayStack=  new ArrayStack(4);
      String key="";
      boolean loop = true;//�����Ƿ��˳��˵�
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:��ʾ��ʾջ");
            System.out.println("exit:�˳�����");
            System.out.println("push:��ʾ������ݵ�ջ");//��ջ
            System.out.println("pop:��ʾ��ջȡ������");//��ջ
            System.out.println("���������ѡ��");
            key =scanner.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("������һ����");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("��ջ��������%d", res);
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

//����һ���� ArrayStack ��ʾջ
class ArrayStack{
    private int maxSize;//ջ��С
    private int[] stack;//���飬����ģ��ջ�����ݷ�������
    private int top =-1;//top��ʾջ������ʼ��Ϊ-1��

    //������
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //ջ�� top = maxSize-1 ջ��

    public  boolean isFull(){
        return  top==maxSize-1;
    }

    //ջ��
    public boolean isEmpty(){
        return top ==-1;
    }

    //��ջ push
    public void push(int value){
        //���ж�ջ��
        if(isFull()){
            System.out.println("ջ��");
            return;
        }
        top++;
        stack[top]=value;
    }

    //��ջ
    public int pop(){
        //��ջ�������ݷ���
        if(isEmpty()){
            throw new RuntimeException("ջΪ��");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //����ջ ����ʱ��Ҫ��ջ����ʼ��ʾ����
    public void list(){
        if(isEmpty()){
            System.out.println("ջ�գ�û������");
            return;
        }

        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}