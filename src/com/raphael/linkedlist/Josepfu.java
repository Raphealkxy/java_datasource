package com.raphael.linkedlist;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.linkedlist
 * @date:2019/7/14
 */
/*
共性：定义元素节点
定义一个连接元素的结构
 */
public class Josepfu {
    public static void main(String[] args) {
        //测试 构建 和 遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入5个小孩节点
        circleSingleLinkedList.showBoy();

         //测试小孩出圈顺序
        circleSingleLinkedList.countBoy(1,2,5);//2,4,1,5,3
    }
}
//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = null;
    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        //nums 做一个数据校验
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy =null;//辅助指针 帮助构建环形变量

        //使用for循环创建我们的环形链表
        for(int i=1;i<=nums;i++){
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i==1){
                first = boy;
                first.setNext(first);//构成环 只是环里只有一个原素
                curBoy =first;//first不能动，只能靠curBoy来移动
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy(){
        //判断是否为空
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此仍然使用一个辅助指针，完成遍历
        Boy curBoy =first;
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if(curBoy.getNext()==first){//说明遍历完毕，first已经之前输出过了
                break;
            }
            curBoy = curBoy.getNext();//curBoy后移
        }
    }

    //根据用户输入，计算出小孩出圈的顺序

    /**
     *
     * @param starNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初由多少小孩在圈中
     */
    public void countBoy(int starNo,int countNum,int nums){
        //对数据进行校验
        if (first == null || starNo < 1 || starNo > nums) {
            System.out.println("你的参数输入有误，请重新输入");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //先让hepler指向链表最初状态的最后一个节点
        while (true) {
            if (helper.getNext() == first) {//说明指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和hepler移动k-1次 移动到游戏开始位置
        for(int j=0;j<starNo-1;j++){
            first = first.getNext();
            helper=helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次 然后出圈
        //这里是一个循环操作，直到权重只有一个节点
        while(true){
            if(helper==first){//说明圈中只有一个节点
                break;
            }
            //让first和helper指针同时移动countNum-1
            for(int j=0;j<countNum-1;j++){
                first =first.getNext();
                helper =helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时将first指向的小孩节点出圈
            first =first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n",first.getNo());
    }
}
//先创建一个boy类，表示一个节点
class Boy{
    private int no;
    private Boy next;//指向下一个节点，默认null
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
