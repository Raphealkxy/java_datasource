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
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //���밴�ձ��˳��2
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
        System.out.println();
        //�����޸Ľڵ�Ĵ���
        HeroNode newHeroNode = new HeroNode(2,"С¬","������~~");
        singleLinkedList.update(newHeroNode);
        //��ʾ
        singleLinkedList.list();
        System.out.println();
        //ɾ��һ���ڵ�
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.list();

        System.out.println("��Ч�ڵ�ĸ���:"+singleLinkedList.getLength());

        //����һ�¿����Ƿ�õ��˵�����K���ڵ�
        HeroNode res = singleLinkedList.findLastIndexNode(1);
        System.out.println("������һ����"+res);
        HeroNode res2 = singleLinkedList.findLastIndexNode(2);
        System.out.println("�����ڶ�����"+res2);

        HeroNode res3 = singleLinkedList.findLastIndexNode(3);
        System.out.println(res3);
    }
}
//����SingleLinkedList�������ǵ�Ӣ��
class SingleLinkedList{
    //�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ��㲻Ҫ����������Ϊ�˱�ʾͷ��㣬��������ݡ�
    private HeroNode head = new HeroNode(0,"","");

    //����ͷ���
    public HeroNode getHead(){
        return head;
    }
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

    //�ڶ��ַ�ʽ�����Ӣ��ʱ������������Ӣ�۲��뵽ָ��λ��
    //������к���������������ʧ�ܣ���������ʾ��
    public void addByOrder(HeroNode heroNode){
        //��Ϊͷ��㲻�ܶ������������Ȼͨ��һ������ָ�루�������������ҵ���ӵ�λ��
        //��Ϊ��������Ϊ�����ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
        HeroNode temp =head;
        boolean flag = false;//flag ��ʶ��ӵı���Ƿ�Ϊ���ڣ�Ĭ��Ϊfalse
        while(true){
            if(temp.next==null){//˵��temp�Ѿ����������
                break;

            }
            if(temp.next.no>heroNode.no){//λ���ҵ�������temp�ĺ������
                break;
            }else if(temp.next.no==heroNode.no){//˵��ϣ����ӵ�heroNode����Ѿ����� ��������ӣ��涨��
                flag =true;//˵����Ŵ���
                break;
            }
            temp =temp.next;//���ƣ�������ǰ����
        }

        //�ж�flag��ֵ
        if(flag){//������ӣ�˵����Ŵ���
            System.out.printf("׼�������Ӣ�۵ı��%d�Ѿ������ˣ����ܼ���\n",heroNode.no);

        }else {
            //���뵽������ temp����
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    //�޸Ľڵ���Ϣ������no������޸ģ���no��Ų��ܸ�
    //1.����newHeroNode��no���޸ļ���
    public void update(HeroNode newHeroNode){
        //�ж��Ƿ�Ϊ��
        if(head.next==null){
            System.out.println("����Ϊ��");
            return;
        }

        //�ҵ���Ҫ�޸ĵĽڵ�
        //�ȶ���һ����������
        HeroNode temp = head.next;
        boolean flag = false;//��ʾ�Ƿ��ҵ��ڵ�
        while (true){
            if(temp==null){
                break;//�Ѿ�����������
            }
            if(temp.no==newHeroNode.no){
                //�ҵ���
                flag = true;
                break;
            }

            temp =temp.next;
        }

        //����flag�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
        if(flag){
            temp.name =newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("û���ҵ����Ϊ%d�Ľڵ㣬�����޸�\n",newHeroNode.no);
        }
    }
    //ɾ���ڵ�
    //˼·
    //1.head���ܶ������������Ҫһ��temp�����ڵ㣬�ҵ���ɾ���ڵ��ǰһ���ڵ�
    //2.˵�������ڱȽ�ʱ����temp.next.no����Ҫ�Ľڵ��no�Ƚ�
    public void del(int no){
        HeroNode temp =head;
        boolean flag = false;//��־�Ƿ��ҵ���ɾ���ڵ��
        while(true){
            if(temp.next==null){//�������
                break;
            }
            if(temp.next.no==no){
                //�ҵ���ɾ���ڵ��ǰһ���ڵ�temp
                flag =true;
                break;
            }
            temp =temp.next;//temp���ƣ�����
        }
        //�ж�flag
        if(flag){//�ҵ�
            //����ɾ��
            temp.next =temp.next.next;
        }else {
            System.out.println("Ҫɾ��Ҫɾ���Ľڵ�");
        }
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

    //ͳ����������Ч�ڵ�ĸ���(����Ǵ�ͷ�ڵ����������ͳ��ͷ��㣩
    /**
     * head�����ͷ���
     * @return ���ص�����Ч�ڵ�ĸ���
     */
    public int getLength(){
        HeroNode temp =head.next;
        //�жϿ�����
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

    //���ҵ������е�����k�����
    public HeroNode findLastIndexNode(int index){

        //�ж�����Ϊ�գ�����null;
        if(head.next==null){
            return null;
        }
    //    temp=temp.next;����Ҫ ��һ����Ч ͷ���next���ǵ�һ���ڵ�
        //��index��У��
        if(index<=0||index>this.getLength()){
            return null;
        }
        HeroNode temp =head.next;//��һ��Ԫ��
        for(int i=0;i<this.getLength()-index;i++){
            temp=temp.next;//��ͼ
        }
        return temp;
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