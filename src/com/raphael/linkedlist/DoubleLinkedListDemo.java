package com.raphael.linkedlist;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.linkedlist
 * @date:2019/7/13
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
           //测试
        System.out.println("双向链表的测试");
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");

        //创建要给链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);

        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.list();

        //修改
        HeroNode2 heroNode2 = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(heroNode2);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        //删除
        System.out.println("删除后的链表情况");
        doubleLinkedList.del(3);
        doubleLinkedList.list();


    }
}

//创建一个双向链表的类
class DoubleLinkedList{

      //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead(){
       return head;
    }

    //遍历双向链表
    public void list(){

       if(head.next==null){
           return;
       }

       HeroNode2 temp =head.next;
       while(temp!=null){
           System.out.println(temp);
           temp=temp.next;
       }

    }

    //添加链表
    public void add(HeroNode2 heroNode2){
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
      //当退出while时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next=heroNode2;
        heroNode2.pre = temp;
    }

    //按序添加链表
    public void addByOrder(HeroNode2 heroNode2){
        //因为head节点不能动，因此需要一个辅助节点
        HeroNode2 temp=head;
        boolean flag =false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(heroNode2.no<temp.next.no){
                break;//这个是要插入的
            }else if(heroNode2.no==temp.next.no){
                flag=true;
                break;
            }
            temp =temp.next;
        }
        //当退出while时，temp就指向了链表的最后
        //形成一个双向链表
        //判断flag的值
        if(flag){//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode2.no);

        }else {
            heroNode2.next = temp.next;
            if(temp.next!=null) {
                temp.next.pre = heroNode2;
            }
            temp.next = heroNode2;
            heroNode2.pre = temp;
            //temp =
        }
    }

    //修改一个节点的内容 可以看到双向链表的节点内容修改和单向链表一样
    //只是节点类型改成HeroNode2
    public void update(HeroNode2 heroNode2){
        HeroNode2 temp =head.next;
        boolean flag =false;
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        while(true){
            if(temp==null){
                break;//没有
            }
            if(temp.no==heroNode2.no){
                flag =true;
                break;//符合要求的点
            }

            temp =temp.next;
        }

       if(flag==true){
           temp.name =heroNode2.name;
           temp.nickname =heroNode2.nickname;
       }
    }

    //从双向链表中删除节点
    //1，对于双向链表 可以直接找到要删除的节点
    //2.找到后自我删除即可
    public void del(int no){
        //判断当前链表为空
        if(head.next==null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;//直接从第一个有效节点开始 原来单链表我希望找到待删除节点前一个节点
        boolean flag =false;
        while (true){
            if(temp==null){//已经到链表最后节点的next处
                break;
            }
           if(temp.no==no){
               //找到待删除节点的前一个节点temp
               flag =true;
               break;
           }
           temp=temp.next;
        }
       if(flag){
           temp.pre.next = temp.next;
           //这里有问题 如果是最后一个节点 就不要执行下面这句话 否则出现空指针异常
           //temp.next
           if(temp.next!=null) {
               temp.next.pre = temp.pre;
           }
       }else {
           System.out.printf("要删除的%d 节点不存在\n",no);
       }
    }
}



//定义一个HeroNode2，每个Hero对象就是一个节点
class HeroNode2 {
    public int no;//编号
    public String name;//名字
    public String nickname;//匿称
    public HeroNode2 next;//指向下一个节点 默认为null
    public HeroNode2 pre;//指向前一个节点  默认为null

    public HeroNode2(int no, String name, String nickname) {
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