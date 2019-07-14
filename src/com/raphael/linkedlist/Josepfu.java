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

         //����С����Ȧ˳��
        circleSingleLinkedList.countBoy(1,2,5);//2,4,1,5,3
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

    //�����û����룬�����С����Ȧ��˳��

    /**
     *
     * @param starNo ��ʾ�ӵڼ���С����ʼ����
     * @param countNum ��ʾ������
     * @param nums ��ʾ����ɶ���С����Ȧ��
     */
    public void countBoy(int starNo,int countNum,int nums){
        //�����ݽ���У��
        if (first == null || starNo < 1 || starNo > nums) {
            System.out.println("��Ĳ���������������������");
            return;
        }
        //����һ������ָ�룬�������С����Ȧ
        Boy helper = first;
        //����heplerָ���������״̬�����һ���ڵ�
        while (true) {
            if (helper.getNext() == first) {//˵��ָ�����һ���ڵ�
                break;
            }
            helper = helper.getNext();
        }
        //С������ǰ������first��hepler�ƶ�k-1�� �ƶ�����Ϸ��ʼλ��
        for(int j=0;j<starNo-1;j++){
            first = first.getNext();
            helper=helper.getNext();
        }
        //��С������ʱ����first��helperָ��ͬʱ�ƶ�m-1�� Ȼ���Ȧ
        //������һ��ѭ��������ֱ��Ȩ��ֻ��һ���ڵ�
        while(true){
            if(helper==first){//˵��Ȧ��ֻ��һ���ڵ�
                break;
            }
            //��first��helperָ��ͬʱ�ƶ�countNum-1
            for(int j=0;j<countNum-1;j++){
                first =first.getNext();
                helper =helper.getNext();
            }
            //��ʱfirstָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ�
            System.out.printf("С��%d��Ȧ\n",first.getNo());
            //��ʱ��firstָ���С���ڵ��Ȧ
            first =first.getNext();
            helper.setNext(first);
        }
        System.out.printf("�������Ȧ�е�С�����%d\n",first.getNo());
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
