package com.raphael.queue;

import java.util.Scanner;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.queue
 * @date:2019/7/9
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
             //测试数组模拟环形队列的案例是否正确
        //测试
        //创建一个队列
        CircleQueue arrayQueue=new CircleQueue(4);//说明设置4，其队列的有效数据最大是3
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
class CircleQueue {

    private int maxSize;//表示数组的最大容量
    private int front;//front变量的含义做一个调整：front就指向队列的第一个元素（原来指向队列第一个元素的前一个位置）
    // front的初始值默认为0
    private int rear;//rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为一个约定。
    // rear的初始值为0
    private int[] arr;//该数组用于存放数组，用于模拟队列

    //创建队列的构造器
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;//空出来最后一个 在这里体现 最后一个直接跳过
    }

    //判断队列有效元素的个数
    public int getElementValue() {
        return (rear + maxSize - front) % maxSize;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {

        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        //rear++;//rear后移
        arr[rear] = n;
        //下面按照思路应该rear+1，但是如果rear已经到达maxsize-1 数组最大下表，但是前面还有空间，要通过取模达到最前端处 这样才能实现数组复用
        //如果不是上述情况，即使使用了下面的公式，仍然可以到达本来该到的地方
        rear=(rear+1)%maxSize;

    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常来处理
            throw new RuntimeException("队列为空，不能取数据");//抛出异常，马上返回，throw本身会导致代码返回
        }

        //这里需要分析出front指向队列的第一个元素
        //先把front对应的值保留到最后一个临时变量
        //将front后移
        int value = arr[front];
        //  front++;考虑front走到顶的情况
        front =(front+1)%maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
//            for (int i = 0; i < arr.length; i++) {
//                System.out.printf("arr[%d]=%d\n", i, arr[i]);
//            }
        //上面这样写 是数组打出来 这样就不是队列了
        //思路：从front开始遍历，遍历多少个
        //需要思考
        for(int i=front;i<front+this.getElementValue();i++)//由于包含front本身 所以<即可
        {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front + 1];
    }

}