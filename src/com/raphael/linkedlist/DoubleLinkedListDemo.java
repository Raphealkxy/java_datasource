package com.raphael.linkedlist;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.linkedlist
 * @date:2019/7/13
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
           //����
        System.out.println("˫������Ĳ���");
        HeroNode2 hero1 = new HeroNode2(1,"�ν�","��ʱ��");
        HeroNode2 hero2 = new HeroNode2(2,"¬����","������");
        HeroNode2 hero3 = new HeroNode2(3,"����","�Ƕ���");
        HeroNode2 hero4 = new HeroNode2(4,"�ֳ�","����ͷ");

        //����Ҫ������
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

        //�޸�
        HeroNode2 heroNode2 = new HeroNode2(4,"����ʤ","������");
        doubleLinkedList.update(heroNode2);
        System.out.println("�޸ĺ���������");
        doubleLinkedList.list();

        //ɾ��
        System.out.println("ɾ������������");
        doubleLinkedList.del(3);
        doubleLinkedList.list();


    }
}

//����һ��˫���������
class DoubleLinkedList{

      //�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��������ž��������
    private HeroNode2 head = new HeroNode2(0,"","");

    //����ͷ�ڵ�
    public HeroNode2 getHead(){
       return head;
    }

    //����˫������
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

    //�������
    public void add(HeroNode2 heroNode2){
        //��Ϊhead�ڵ㲻�ܶ������������Ҫһ����������temp
        HeroNode2 temp = head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
      //���˳�whileʱ��temp��ָ������������
        //�γ�һ��˫������
        temp.next=heroNode2;
        heroNode2.pre = temp;
    }

    //�����������
    public void addByOrder(HeroNode2 heroNode2){
        //��Ϊhead�ڵ㲻�ܶ��������Ҫһ�������ڵ�
        HeroNode2 temp=head;
        boolean flag =false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(heroNode2.no<temp.next.no){
                break;//�����Ҫ�����
            }else if(heroNode2.no==temp.next.no){
                flag=true;
                break;
            }
            temp =temp.next;
        }
        //���˳�whileʱ��temp��ָ������������
        //�γ�һ��˫������
        //�ж�flag��ֵ
        if(flag){//������ӣ�˵����Ŵ���
            System.out.printf("׼�������Ӣ�۵ı��%d�Ѿ������ˣ����ܼ���\n",heroNode2.no);

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

    //�޸�һ���ڵ������ ���Կ���˫������Ľڵ������޸ĺ͵�������һ��
    //ֻ�ǽڵ����͸ĳ�HeroNode2
    public void update(HeroNode2 heroNode2){
        HeroNode2 temp =head.next;
        boolean flag =false;
        if(head.next==null){
            System.out.println("����Ϊ��");
            return;
        }
        while(true){
            if(temp==null){
                break;//û��
            }
            if(temp.no==heroNode2.no){
                flag =true;
                break;//����Ҫ��ĵ�
            }

            temp =temp.next;
        }

       if(flag==true){
           temp.name =heroNode2.name;
           temp.nickname =heroNode2.nickname;
       }
    }

    //��˫��������ɾ���ڵ�
    //1������˫������ ����ֱ���ҵ�Ҫɾ���Ľڵ�
    //2.�ҵ�������ɾ������
    public void del(int no){
        //�жϵ�ǰ����Ϊ��
        if(head.next==null){
            System.out.println("����Ϊ�գ��޷�ɾ��");
            return;
        }
        HeroNode2 temp = head.next;//ֱ�Ӵӵ�һ����Ч�ڵ㿪ʼ ԭ����������ϣ���ҵ���ɾ���ڵ�ǰһ���ڵ�
        boolean flag =false;
        while (true){
            if(temp==null){//�Ѿ����������ڵ��next��
                break;
            }
           if(temp.no==no){
               //�ҵ���ɾ���ڵ��ǰһ���ڵ�temp
               flag =true;
               break;
           }
           temp=temp.next;
        }
       if(flag){
           temp.pre.next = temp.next;
           //���������� ��������һ���ڵ� �Ͳ�Ҫִ��������仰 ������ֿ�ָ���쳣
           //temp.next
           if(temp.next!=null) {
               temp.next.pre = temp.pre;
           }
       }else {
           System.out.printf("Ҫɾ����%d �ڵ㲻����\n",no);
       }
    }
}



//����һ��HeroNode2��ÿ��Hero�������һ���ڵ�
class HeroNode2 {
    public int no;//���
    public String name;//����
    public String nickname;//���
    public HeroNode2 next;//ָ����һ���ڵ� Ĭ��Ϊnull
    public HeroNode2 pre;//ָ��ǰһ���ڵ�  Ĭ��Ϊnull

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