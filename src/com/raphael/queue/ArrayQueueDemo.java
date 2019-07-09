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
           //����
        //����һ������
        ArrayQueue arrayQueue=new ArrayQueue(3);
        char key = ' ';//�����û�����
        Scanner scanner = new Scanner(System.in);
        boolean loop =true;
        //����˵�
        while (loop){
            System.out.println("s(show):��ʾ����");
            System.out.println("e(exit):�˳�����");
            System.out.println("a(add):������ݵ�����");
            System.out.println("g(get):�鿴����ͷ������");
            key = scanner.next().charAt(0);//����һ���ַ�
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g'://ȡ������
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://�鿴����ͷ������
                    try{
                        int res=arrayQueue.headQueue();
                        System.out.printf("����ͷ��������%d\n",res);
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
        System.out.println("�����˳�");
    }
}

//ʹ������ģ����� ��дһ��ArrayQueue��
class ArrayQueue{

    private int maxSize;//��ʾ������������
    private int front;//����ͷ
    private int rear;//����β
    private int []arr;//���������ڴ�����飬����ģ�����

    //�������еĹ�����
    public ArrayQueue(int arrMaxSize){
        maxSize =arrMaxSize;
        arr = new int[maxSize];
        front = -1;//ָ�����ͷ����������front��ָ����е�ǰһ��λ�ã����ڶ���
        rear =-1;//ָ�����β����ָ����е�β�����ڶ��е����һ�����ݣ������Ƕ��е����һ�����ݣ�
    }
    //�ж϶����Ƿ���
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty(){
        return rear==front;
    }
    //������ݵ�����
    public void addQueue(int n){
        //�ж϶����Ƿ���
        if(isFull()){
            System.out.println("�����������ܼ�������");
            return;
        }

        rear++;//rear����
        arr[rear]=n;
    }

    //��ȡ���е����ݣ�������
    public int getQueue(){
        //�ж϶����Ƿ�Ϊ��
        if(isEmpty()){
            //ͨ���׳��쳣������
            throw new RuntimeException("����Ϊ�գ�����ȡ����");//�׳��쳣�����Ϸ��أ�throw����ᵼ�´��뷵��
        }
        front++;//front����
        return arr[front];
    }

    //��ʾ���е���������
    public void showQueue(){
        //����
        if(isEmpty()){
            System.out.println("���пյģ�û������");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //��ʾ���е�ͷ���ݣ�����ȡ������
    public int headQueue(){
        if(isEmpty()){
            throw  new RuntimeException("���пյģ�û������");
        }
        return arr[front+1];
    }
}