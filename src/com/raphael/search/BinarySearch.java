package com.raphael.search;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
//ע�⣺ʹ�ö��ֲ��ҵ�ǰ���Ǹ������������
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] ={1,8,10,89,1000,1234};
        int resultIndex = binarySearch(arr,0,arr.length-1,88);
        System.out.println("resIndex="+resultIndex);
    }

    //���ֲ����㷨

    /**
     *
     * @param arr
     * @param left �������
     * @param right �ұ�����
     * @param findval Ҫ���ҵ�ֵ
     * @return ���û���ҵ����ͷ���-1
     */
    public static int binarySearch(int []arr,int left,int right,int findval){

        //��left>rigthʱ��˵���ݹ��������飬����û���ҵ�  �ݹ�ջ ��һ��ֱ��
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findval>midVal){
            //���ҵݹ�
            return binarySearch(arr,mid+1,right,findval);
        }else if(findval<midVal){
            return  binarySearch(arr,left,mid-1,findval);
        }else {
            return mid;
        }
    }
}
