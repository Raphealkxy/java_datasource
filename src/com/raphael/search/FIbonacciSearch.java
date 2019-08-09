package com.raphael.search;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/9
 */
public class FIbonacciSearch {

    public static int maxSize=20;
    public static void main(String[] args) {
        int [] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,1));

    }
    //��Ϊ��������mid = low+F(k-1)-1 ����Ҫʹ�õ�쳲��������У����������Ҫ�Ȼ�ȡ��һ��쳲���������
    //�ǵݹ鷽���õ�һ��쳲���������
    public static int[] fib(){
        int [] f= new  int[maxSize];
        f[0]=1;
        f[1]=1;
        for(int i=2;i<maxSize;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    //��д쳲����������㷨
    //�ǵݹ�
    /**
     *
     * @param a
     * @param key ��Ҫ���ҵĹؼ���ֵ
     * @return ���ض�Ӧ�±꣬���û�з���-1
     */
    public static int fibSearch(int []a,int key){
        int low =0;
        int high = a.length-1;
        int k=0;//��ʾ쳲��������еķָ����ֵ���±�
        int mid =0;//���midֵ
        int f[] = fib();
        //��ȡ��쳲������ָ���ֵ���±�
        while(high>f[k]-1){
            k++;
        }
        //��Ϊf[k]ֵ���ܴ���a�ĳ��ȣ����������Ҫʹ��Arrays�࣬����һ���µ����飬����ָ��a
        //�������Ĳ��� ��ʹ��0���
        int []temp = Arrays.copyOf(a,f[k]);
        //ʵ������Ҫʹ��a���������������temp
        //temp={1,8,10,89,1000,1234,0,0,0} =>{1,8,10,89,1000,1234,1234,1234,1234}
        for(int i=high+1;i<temp.length;i++){
            temp[i]=a[high];
        }

        //ʹ��while��ѭ������ �ҵ����ǵ���key
        while (low<=high){
                mid=low+f[k-1]-1;
                if(key<temp[mid]){//����Ӧ�ü��������ǰ�����
                        high =mid-1;
                        //Ϊʲô��k--;
                        //˵��
                       //1.ȫ��Ԫ��=ǰ���Ԫ��+�����Ԫ��
                       //2.f[k] = f[k-1]+f[k-2]
                      //��Ϊǰ����f[k-1]��Ԫ�أ����Կ��Լ������f[k-1]=f[k-2]+f[k-3]
                    //����f[k-1]��ǰ���������k--
                    //���´�ѭ��mid = f[k-1-1]-1
                    k--;
                }else if(key>temp[mid]){//˵��Ӧ�ü���������ĺ�����ң��ұߣ�
                    low =mid+1;
                    //
                    k-=2;//���� //����ĸ���//����ͼ�����������

                }else {
                    //��Ҫ
                    if(mid<=high){
                        return mid;
                    }else {
                        return high;
                    }
                }
        }
        return -1;
    }
}
