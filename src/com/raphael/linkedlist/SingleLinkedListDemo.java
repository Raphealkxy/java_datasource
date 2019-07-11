package com.raphael.linkedlist;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.linkedlist
 * @date:2019/7/11
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
            //���в���
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
        HeroNode hero2 = new HeroNode(2,"¬����","������");
        HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
        HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList =new SingleLinkedList();
        //����
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //��ʾ
        singleLinkedList.list();

    }
}
//����SingleLinkedList�������ǵ�Ӣ��
class SingleLinkedList{
    //�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ��㲻Ҫ����������Ϊ�˱�ʾͷ��㣬��������ݡ�
    private HeroNode head = new HeroNode(0,"","");

    //��ӽڵ㵽�����б�
    //˼·���������Ǳ��˳��ʱ
    //1.�ҵ���ǰ��������ڵ�
    //2.���������ڵ��next��ָ���µĽڵ�
    public void add(HeroNode heroNode){
        //��Ϊhead���ܶ������������Ҫһ����������temp
        HeroNode temp = head;
        //�������� �ҵ����
        while(true){
            //�ҵ���������
            if(temp.next==null){
                break;
            }
            //���û���ҵ���� �ͽ�
            temp =temp.next;
        }

        //���˳�whileѭ��ʱ��temp��ָ������������
        //���������ڵ��next ָ���µĽڵ�
        temp.next = heroNode;
    }

    //��ʾ����������
    public void list(){
        //�ж������Ƿ�Ϊ��
        if(head.next==null){
            System.out.println("����Ϊ��");
            return;
        }
        //��Ϊͷ��㣬���ܶ������������Ҫһ����������������
        HeroNode temp =head.next;
        while(true){
            //�ж��Ƿ��������
            if(temp==null){
                break;
            }
            //����ڵ���Ϣ
            System.out.println(temp.toString());
            //��next���� һ��ע��
            temp =temp.next;

        }
    }
}
//����һ��HeroNode��ÿ��Hero�������һ���ڵ�
class HeroNode{
    public int no;//���
    public String name;//����
    public String nickname;//���
    public HeroNode next;//ָ����һ���ڵ�

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