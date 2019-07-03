import sun.swing.BakedArrayList;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

    private static List<Integer>list1 = new ArrayList<Integer>();
    //�ڵ�����ڲ���ķ�ʽ
    private static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.left=null;
            this.right=null;
            this.data = data;
        }
    }

   private static boolean flag=true;
    //�����ü��ϵ���ʽ
    private static List<Node> nodeList = null;
    //ԭʼ���ݲ�����������¼
    private int []array = {1,2,3,4,5,6,7,8,9};
    private static boolean isSubNode(Node higher, Node lower) {

        if (higher.left == null && higher.right == null)
            return false;
        if (higher.left == lower || higher.right == lower)
            return true;
        Node tempLeft = higher.left;
        Node tempRight = higher.right;
        return isSubNode(tempLeft, lower) || isSubNode(tempRight, lower);

    }
    //java����������
    public void createBintree(){
        nodeList = new LinkedList<Node>();
        //����ֵת��Ϊ�ڵ�
        System.out.println("�������������Ϊ��");
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
        for(int i=0;i<array.length;i++){
            nodeList.add(new Node(array[i]));
        }
        //������һ��Ϊ���ڵ� index*2+1Ϊ���� index*2+2Ϊ�Һ���
        for(int i=0;i<array.length/2-1;i++){
            //����
            nodeList.get(i).left=nodeList.get(i*2+1);
            //�Һ���
            nodeList.get(i).right = nodeList.get(i*2+2);
        }
      //���һ�����ڵ㣬���һ�����ڵ�����һ�����ӣ�Ҳ����û���Һ��ӣ�����Ҫ��������
        int lastParentIndex = array.length/2-1;
        //����
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex*2+1);
        //�ж��Ƿ����Һ��� ������ ���鳤��Ϊ���� ����������������Һ���
        if(array.length%2==1){
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex*2+2);
        }
    }
    //java����������
    //�������
    public static void preTraverse(Node node){
        if(node==null)
            return;
        list1.add(node.data);
        System.out.print(node.data+" ");
        preTraverse(node.left);
        preTraverse(node.right);
    }
    //�������
    public static  void  inorerTraverse(Node node){
        if(node==null)
            return;
        inorerTraverse(node.left);
        System.out.print(node.data+" ");
        inorerTraverse(node.right);
    }
    //�������
    public static  void postOrderTraverse(Node node){
        if(node==null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data+" ");
    }

    //Ѱ������������� ��Ҫ������ڵ����ҪѰ�ҵ������ڵ�
    public static Node lowestCommAncestor(Node origin,Node root,int p,int q){

       // if(isSubNode(p,q))
        if(origin.data ==p||origin.data==q){
            return new Node(-99999);
        }
         if(!list1.contains(p)||!list1.contains(q))
             return new Node(99999);
           //�ݹ�����ж�����
        if(root==null||root.data == p||root.data ==q)
            return root;
        //��ȥ����������
        Node leftone =lowestCommAncestor(origin,root.left,p,q);
//        System.out.println(leftone.data);
        //ȥ����������
        Node rightone=lowestCommAncestor(origin,root.right,p,q);
    //    System.out.println(rightone.data);
        //������û�� ˵������������
        if(leftone ==null){
            return rightone;
        }
        //������û�� ˵������������
       if(rightone == null){
           return leftone;
       }

//       if(leftone==rightone){
//
//       }
        //�������ҵ��ĵ��Ӧ��ֵ���غϵ� �����غϵ����һ�����ڵ�

       //����Ϊ�� ˵��������Ҫ�ҵ�����������ڵ�
        return root;

       //�����ڶ�Ϊ�յ��������Ϊ����� ���Ƕ������еĵ�
    }


    //java������Ѱ�ҹ�������
    public static void main(String[] args) {
           Main main  =new Main();
           main.createBintree();
           Node root  = nodeList.get(0);

        System.out.println("����");
        preTraverse(root);
        System.out.println();
        System.out.println("����");
        inorerTraverse(root);
        System.out.println();
        System.out.println("����");
        postOrderTraverse(root);
        System.out.println();
        System.out.println("����������ڵ㣺������4,5����������ڵ�");
        Node originroot =root;
        Node node = lowestCommAncestor(originroot,root,4,5);
        System.out.println(node.data);
        System.out.println("����������ڵ㣺������4,6����������ڵ�");
        Node node1 = lowestCommAncestor(originroot,root,4,6);
        System.out.println(node1.data);
        System.out.println("����������ڵ㣺������1,3����������ڵ�");
        Node node2 = lowestCommAncestor(originroot,root,1,3);
//        System.out.println(node2.data);
        System.out.println("����������ڵ㣺������2,4����������ڵ�");
        int a=2,b=8;
        Node node3 = lowestCommAncestor(originroot,root,a,b);
        if(node3.data==a||node3.data==b){
            int index=0;

                for(int i=0;i<nodeList.size();i++){
                    if(root.data==nodeList.get(i).data){
                        index =i/2;
                    }
                }
            System.out.println(nodeList.get(index).data);
            }

       // System.out.println(node3.data);
        Node node4 = lowestCommAncestor(originroot,root,10,4);
        if (node4.data==99999){
            System.out.println("�㲻������");
        }
        Node node5 = lowestCommAncestor(originroot,root,1,4);
        if (node5.data==-99999){
            System.out.println("���ڵ㸸�ڵ�Ϊ��");
        }
//        Node node4 = main.lowestCommonAncestor(root,nodeList.get(11),nodeList.get(3));
//        System.out.println(node4.data);

    }
}
