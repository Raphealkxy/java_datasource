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
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //显示
        singleLinkedList.list();

    }
}
//定义SingleLinkedList管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头结点不要动，作用是为了表示头结点，不存放数据。
    private HeroNode head = new HeroNode(0,"","");

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