package com.raphael.linkedlist;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.linkedlist
 * @date:2019/7/11
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
            //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList =new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //加入按照编号顺序2
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
        System.out.println();
        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        //显示
        singleLinkedList.list();
        System.out.println();
        //删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.list();

        System.out.println("有效节点的个数:"+singleLinkedList.getLength());

        //测试一下看看是否得到了倒数第K个节点
        HeroNode res = singleLinkedList.findLastIndexNode(1);
        System.out.println("倒数第一个："+res);
        HeroNode res2 = singleLinkedList.findLastIndexNode(2);
        System.out.println("倒数第二个："+res2);

        HeroNode res3 = singleLinkedList.findLastIndexNode(3);
        System.out.println(res3);
    }
}
//定义SingleLinkedList管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头结点不要动，作用是为了表示头结点，不存放数据。
    private HeroNode head = new HeroNode(0,"","");

    //返回头结点
    public HeroNode getHead(){
        return head;
    }
    //添加节点到单项列表
    //思路：当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next，指向新的节点
    public void add(HeroNode heroNode){
        //因为head不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表 找到最后
        while(true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后 就将
            temp =temp.next;
        }

        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //（如果有和这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode){
        //因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因为我们找到temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp =head;
        boolean flag = false;//flag 标识添加的编号是否为存在，默认为false
        while(true){
            if(temp.next==null){//说明temp已经在链表最后
                break;

            }
            if(temp.next.no>heroNode.no){//位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no==heroNode.no){//说明希望添加的heroNode编号已经存在 不能再添加（规定）
                flag =true;//说明编号存在
                break;
            }
            temp =temp.next;//后移，遍历当前链表
        }

        //判断flag的值
        if(flag){//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode.no);

        }else {
            //插入到链表中 temp后面
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    //修改节点信息，根据no编号来修改，即no编号不能改
    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        //找到需要修改的节点
        //先定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到节点
        while (true){
            if(temp==null){
                break;//已经遍历完链表
            }
            if(temp.no==newHeroNode.no){
                //找到了
                flag = true;
                break;
            }

            temp =temp.next;
        }

        //根据flag判断是否找到要修改的节点
        if(flag){
            temp.name =newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号为%d的节点，不能修改\n",newHeroNode.no);
        }
    }
    //删除节点
    //思路
    //1.head不能动，因此我们需要一个temp辅助节点，找到待删除节点的前一个节点
    //2.说明我们在比较时，是temp.next.no和需要的节点的no比较
    public void del(int no){
        HeroNode temp =head;
        boolean flag = false;//标志是否找到待删除节点的
        while(true){
            if(temp.next==null){//链表最后
                break;
            }
            if(temp.next.no==no){
                //找到待删除节点的前一个节点temp
                flag =true;
                break;
            }
            temp =temp.next;//temp后移，遍历
        }
        //判断flag
        if(flag){//找到
            //可以删除
            temp.next =temp.next.next;
        }else {
            System.out.println("要删除要删除的节点");
        }
    }
    //显示链表（遍历）
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp =head.next;
        while(true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp.toString());
            //将next后移 一定注意
            temp =temp.next;

        }
    }

    //统计链表中有效节点的个数(如果是带头节点的链表，需求不统计头结点）
    /**
     * head链表的头结点
     * @return 返回的是有效节点的个数
     */
    public int getLength(){
        HeroNode temp =head.next;
        //判断空链表
        if(head.next==null){
            return 0;
        }
        int count=0;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    //查找单链表中倒数第k个结点
    public HeroNode findLastIndexNode(int index){

        //判断链表为空，返回null;
        if(head.next==null){
            return null;
        }
    //    temp=temp.next;不需要 第一个有效 头结点next就是第一个节点
        //对index做校验
        if(index<=0||index>this.getLength()){
            return null;
        }
        HeroNode temp =head.next;//第一个元素
        for(int i=0;i<this.getLength()-index;i++){
            temp=temp.next;//画图
        }
        return temp;
    }
}
//定义一个HeroNode，每个Hero对象就是一个节点
class HeroNode{
    public int no;//编号
    public String name;//名字
    public String nickname;//匿称
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}