package com.raphael.linkedlist;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.linkedlist
 * @date:2019/7/14
 */
/*
���ԣ�����Ԫ�ؽڵ�
����һ������Ԫ�صĽṹ
 */
public class Josepfu {
    public static void main(String[] args) {
        //���� ���� �� ����
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//����5��С���ڵ�
        circleSingleLinkedList.showBoy();
        

    }
}
//����һ�����εĵ�������
class CircleSingleLinkedList{
    //����һ��first�ڵ㣬��ǰû�б��
    private Boy first = null;
    //���С���ڵ㣬������һ����������
    public void addBoy(int nums){
        //nums ��һ������У��
        if(nums<1){
            System.out.println("nums��ֵ����ȷ");
            return;
        }
        Boy curBoy =null;//����ָ�� �����������α���

        //ʹ��forѭ���������ǵĻ�������
        for(int i=1;i<=nums;i++){
            //���ݱ�ţ�����С���ڵ�
            Boy boy = new Boy(i);
            //����ǵ�һ��С��
            if(i==1){
                first = boy;
                first.setNext(first);//���ɻ� ֻ�ǻ���ֻ��һ��ԭ��
                curBoy =first;//first���ܶ���ֻ�ܿ�curBoy���ƶ�
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //������ǰ�Ļ�������
    public void showBoy(){
        //�ж��Ƿ�Ϊ��
        if(first==null){
            System.out.println("����Ϊ��");
            return;
        }
        //��Ϊfirst���ܶ��������Ȼʹ��һ������ָ�룬��ɱ���
        Boy curBoy =first;
        while (true){
            System.out.printf("С���ı��%d\n",curBoy.getNo());
            if(curBoy.getNext()==first){//˵��������ϣ�first�Ѿ�֮ǰ�������
                break;
            }
            curBoy = curBoy.getNext();//curBoy����
        }
    }
}
//�ȴ���һ��boy�࣬��ʾһ���ڵ�
class Boy{
    private int no;
    private Boy next;//ָ����һ���ڵ㣬Ĭ��null
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
