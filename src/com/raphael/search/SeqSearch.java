package com.raphael.search;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};//û��˳�������
        int index =seqSearch(arr,11);
        if(index==-1){
            System.out.println("û�в��ҵ����ҵ�ֵ");
        }else {
            System.out.println("�ҵ����±�Ϊ="+index);
        }
    }

    /**
     * ����ʵ�ֵ����Բ������ҵ�һ������������ֵ�ͷ��أ����Ҫ���ҵ����еģ����ü��Ϸ���
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int []arr,int value){
        //���Բ�������һ�ȶԣ���������ͬ��ֵʱ���ͷ����±�
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
