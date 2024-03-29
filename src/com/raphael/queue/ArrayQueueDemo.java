package com.raphael.queue;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.queue
 * @date:2019/7/9
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
           //测试
        //创建一个队列
        ArrayQueue arrayQueue=new ArrayQueue(3);
        char key = ' ';//接收用户收入
        Scanner scanner = new Scanner(System.in);
        boolean loop =true;
        //输出菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头的数据
                    try{
                        int res=arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列 编写一个ArrayQueue类
class ArrayQueue{

    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int []arr;//该数组用于存放数组，用于模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize =arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列的前一个位置，不在队列
        rear =-1;//指向队列尾部，指向队列的尾部，在队列的最后一个数据（即就是队列的最后一个数据）
    }
    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }

        rear++;//rear后移
        arr[rear]=n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("队列为空，不能取数据");//抛出异常，马上返回，throw本身会导致代码返回
        }
        front++;//front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列空的，没有数据");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列空的，没有数据");
        }
        return arr[front+1];
    }
}