package com.raphael.sparsearray;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sparsearray
 * @date:2019/7/3
 */
public class SparseArray {
    //����һ��ԭʼ�Ķ�ά����11*11
    //0����ʾû�����ӣ�1��ʾ���ӣ�2��ʾ����
    public static void main(String[] args) {
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][4]=2;
        //���ԭʼ�Ķ�ά����
        System.out.println("ԭʼ�Ķ�ά����");
        for(int [] row:chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //����ά����תϡ������
        //1.�ȱ�����ά���� �õ���0���ݵĸ���
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++)
                if(chessArr1[i][j]!=0){
                    sum++;
                }
        }

        //2.������Ӧ��ϡ������
        int sparseArr[][]=new int[sum+1][3];

        //��ϡ�����鸳ֵ
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //������ά���� ����0��ֵ��ŵ�ϡ��������
        int row=0;
        for(int i=0;i<11;i++)
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    row++;
                    sparseArr[row][0]=i;
                    sparseArr[row][1]=j;
                    sparseArr[row][2]=chessArr1[i][j];
                }
            }

        //���ϡ���������ʽ
        System.out.println();
        System.out.println("�õ���ϡ������Ϊ~~~~");
        for(int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //��ϡ������ �ָ���ԭʼ�Ķ�ά����
        //�ȶ�ȡϡ������ĵ�һ�� ���ݵ�һ�д���ԭʼ�Ķ�ά���� ���������chessArr2=int[11][11]
        //��ȡϡ������� ���е����� ������ԭʼ�Ķ�ά����


        int newArray[][]=new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i=1;i<=row;i++){
            newArray[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        System.out.println("��ӡ��ȡ�����Ķ�ά����");

        for(int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%d\t", newArray[i][j]);
            }
            System.out.println();
        }
    }




}
