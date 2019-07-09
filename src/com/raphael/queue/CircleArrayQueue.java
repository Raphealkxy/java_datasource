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
             //��������ģ�⻷�ζ��еİ����Ƿ���ȷ
        //����
        //����һ������
        CircleQueue arrayQueue=new CircleQueue(4);//˵������4������е���Ч���������3
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
class CircleQueue {

    private int maxSize;//��ʾ������������
    private int front;//front�����ĺ�����һ��������front��ָ����еĵ�һ��Ԫ�أ�ԭ��ָ����е�һ��Ԫ�ص�ǰһ��λ�ã�
    // front�ĳ�ʼֵĬ��Ϊ0
    private int rear;//rear�����ĺ�����һ��������rearָ����е����һ��Ԫ�صĺ�һ��λ�ã���Ϊϣ���ճ�һ���ռ���Ϊһ��Լ����
    // rear�ĳ�ʼֵΪ0
    private int[] arr;//���������ڴ�����飬����ģ�����

    //�������еĹ�����
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //�ж϶����Ƿ���
    public boolean isFull() {
        return (rear + 1) % maxSize == front;//�ճ������һ�� ���������� ���һ��ֱ������
    }

    //�ж϶�����ЧԪ�صĸ���
    public int getElementValue() {
        return (rear + maxSize - front) % maxSize;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return rear == front;
    }

    //������ݵ�����
    public void addQueue(int n) {

        //�ж϶����Ƿ���
        if (isFull()) {
            System.out.println("�����������ܼ�������");
            return;
        }
        //rear++;//rear����
        arr[rear] = n;
        //���水��˼·Ӧ��rear+1���������rear�Ѿ�����maxsize-1 ��������±�����ǰ�滹�пռ䣬Ҫͨ��ȡģ�ﵽ��ǰ�˴� ��������ʵ�����鸴��
        //������������������ʹʹ��������Ĺ�ʽ����Ȼ���Ե��ﱾ���õ��ĵط�
        rear=(rear+1)%maxSize;

    }

    //��ȡ���е����ݣ�������
    public int getQueue() {
        //�ж϶����Ƿ�Ϊ��
        if (isEmpty()) {
            //ͨ���׳��쳣������
            throw new RuntimeException("����Ϊ�գ�����ȡ����");//�׳��쳣�����Ϸ��أ�throw����ᵼ�´��뷵��
        }

        //������Ҫ������frontָ����еĵ�һ��Ԫ��
        //�Ȱ�front��Ӧ��ֵ���������һ����ʱ����
        //��front����
        int value = arr[front];
        //  front++;����front�ߵ��������
        front =(front+1)%maxSize;
        return value;
    }

    //��ʾ���е���������
    public void showQueue() {
        //����
        if (isEmpty()) {
            System.out.println("���пյģ�û������");
            return;
        }
//            for (int i = 0; i < arr.length; i++) {
//                System.out.printf("arr[%d]=%d\n", i, arr[i]);
//            }
        //��������д ���������� �����Ͳ��Ƕ�����
        //˼·����front��ʼ�������������ٸ�
        //��Ҫ˼��
        for(int i=front;i<front+this.getElementValue();i++)//���ڰ���front���� ����<����
        {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //��ʾ���е�ͷ���ݣ�����ȡ������
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("���пյģ�û������");
        }
        return arr[front + 1];
    }

}