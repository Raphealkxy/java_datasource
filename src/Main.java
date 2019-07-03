import sun.swing.BakedArrayList;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

    private static List<Integer>list1 = new ArrayList<Integer>();
    //节点采用内部类的方式
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
    //树采用集合的形式
    private static List<Node> nodeList = null;
    //原始数据采用数组来记录
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
    //java二叉树构造
    public void createBintree(){
        nodeList = new LinkedList<Node>();
        //将数值转换为节点
        System.out.println("输入的样本序列为：");
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
        for(int i=0;i<array.length;i++){
            nodeList.add(new Node(array[i]));
        }
        //数组中一半为父节点 index*2+1为左孩子 index*2+2为右孩子
        for(int i=0;i<array.length/2-1;i++){
            //左孩子
            nodeList.get(i).left=nodeList.get(i*2+1);
            //右孩子
            nodeList.get(i).right = nodeList.get(i*2+2);
        }
      //最后一个父节点，最后一个父节点至少一个孩子，也可能没有右孩子，特例要单独处理
        int lastParentIndex = array.length/2-1;
        //左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex*2+1);
        //判断是否有右孩子 条件是 数组长度为奇数 满足这个条件才有右孩子
        if(array.length%2==1){
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex*2+2);
        }
    }
    //java二叉树遍历
    //先序遍历
    public static void preTraverse(Node node){
        if(node==null)
            return;
        list1.add(node.data);
        System.out.print(node.data+" ");
        preTraverse(node.left);
        preTraverse(node.right);
    }
    //中序遍历
    public static  void  inorerTraverse(Node node){
        if(node==null)
            return;
        inorerTraverse(node.left);
        System.out.print(node.data+" ");
        inorerTraverse(node.right);
    }
    //后序遍历
    public static  void postOrderTraverse(Node node){
        if(node==null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data+" ");
    }

    //寻找最近公共祖先 需要传入根节点和需要寻找的两个节点
    public static Node lowestCommAncestor(Node origin,Node root,int p,int q){

       // if(isSubNode(p,q))
        if(origin.data ==p||origin.data==q){
            return new Node(-99999);
        }
         if(!list1.contains(p)||!list1.contains(q))
             return new Node(99999);
           //递归结束判断条件
        if(root==null||root.data == p||root.data ==q)
            return root;
        //先去左子树上找
        Node leftone =lowestCommAncestor(origin,root.left,p,q);
//        System.out.println(leftone.data);
        //去右子树上找
        Node rightone=lowestCommAncestor(origin,root.right,p,q);
    //    System.out.println(rightone.data);
        //左子树没有 说明在右子树上
        if(leftone ==null){
            return rightone;
        }
        //右子树没有 说明在左子树上
       if(rightone == null){
           return leftone;
       }

//       if(leftone==rightone){
//
//       }
        //如果最后找到的点对应的值是重合的 返回重合点的上一级父节点

       //都不为空 说明这点就是要找的最近公共父节点
        return root;

       //不存在都为空的情况，因为输入的 都是二叉树中的点
    }


    //java二叉树寻找公共祖先
    public static void main(String[] args) {
           Main main  =new Main();
           main.createBintree();
           Node root  = nodeList.get(0);

        System.out.println("先序");
        preTraverse(root);
        System.out.println();
        System.out.println("中序");
        inorerTraverse(root);
        System.out.println();
        System.out.println("后序");
        postOrderTraverse(root);
        System.out.println();
        System.out.println("最近公共父节点：例如求4,5的最近公共节点");
        Node originroot =root;
        Node node = lowestCommAncestor(originroot,root,4,5);
        System.out.println(node.data);
        System.out.println("最近公共父节点：例如求4,6的最近公共节点");
        Node node1 = lowestCommAncestor(originroot,root,4,6);
        System.out.println(node1.data);
        System.out.println("最近公共父节点：例如求1,3的最近公共节点");
        Node node2 = lowestCommAncestor(originroot,root,1,3);
//        System.out.println(node2.data);
        System.out.println("最近公共父节点：例如求2,4的最近公共节点");
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
            System.out.println("点不在树中");
        }
        Node node5 = lowestCommAncestor(originroot,root,1,4);
        if (node5.data==-99999){
            System.out.println("根节点父节点为空");
        }
//        Node node4 = main.lowestCommonAncestor(root,nodeList.get(11),nodeList.get(3));
//        System.out.println(node4.data);

    }
}
