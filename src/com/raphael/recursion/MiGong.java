package com.raphael.recursion;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.recursion
 * @date:2019/7/20
 */
public class MiGong {

    public static void main(String[] args) {
        //�ȴ���һ����ά���� ģ���Թ�
        //��ͼ
        int[][] map = new int[8][7];
        //ʹ��1��ʾǽ
        //����ȫ����Ϊ1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //����ȫ����Ϊ1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //���õ��� ��1��ʾ //���������ṩ��ͼ
        map[3][1]=1;
        map[3][2]=1;

        //�����ͼ
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //ʹ�õݹ�����С����·
        //setWay(map,1,1);
        setWay2(map,1,1);
        //����µĵ�ͼ С���߹� ����ʶ���õ�ͼ
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    //ʹ�õݹ��������С����·
    //˵��
    //1.map��ʾ��ͼ
    //2.i,j��ʾ�ӵ�ͼ���ĸ�λ�ÿ�ʼ������1,1��
    //3.���С���ܵ�map[6][5]λ�ã���˵��ͨ·�ҵ�
    //4.Լ������map[i][j]Ϊ0��ʾ�õ�û���߹���Ϊ1��ʾǽ��2��ʾͨ·�����ߣ�3��ʾ�õ��Ѿ��߹��������߲�ͨ
    //�����Թ�ʱ����Ҫȷ��һ�����ԣ��� �� �� �� ����õ��߲�ͨ �ٻ���
    /**
     *
     * @param map ��ʾ��ͼ
     * @param i ���Ǹ�λ�ÿ�ʼ��
     * @param j
     * @return ����ҵ�ͨ·���ͷ���true�����򷵻�false
     */
    /**
     * ���С���ܹ���6,5��λ�ã�˵��·�������ҵ�
     * Լ������map[i][j]Ϊ0��ʾ�õ�û���߹�����Ϊ1��ʾǽ��2��ʾͨ·�������ߣ�3��ʾ�õ��Ѿ��߹��������߲�ͨ
     *���Թ�ʱ����Ҫȷ��һ�����ԣ�����������-����-����-���� ����Լ���ò��� ����õ��߲�ͨ �ڻ���
     */
    //ʹ�õݹ��������С����·
    public static boolean setWay(int [][] map,int i,int j){
        if(map[6][5]==2){//ͨ·�Ѿ��ҵ�
            return  true;
        }else {
            if(map[i][j]==0){
                //�����ǰ��㻹û���߹������ղ�����
                map[i][j]=2;//���߹���Ȼ������һ��̽��
                if(setWay(map,i+1,j)){//������
                    return true;
                }else if(setWay(map,i,j+1)){//�����ߣ��߲�ͨ��������
                    return true;
                }else if(setWay(map,i-1,j)){//�����ߣ��߲�ͨ��������
                    return true;
                }else if(setWay(map,i,j-1)){//�����ߣ��߲�ͨ��������
                    //������
                    return true;
                }else {
                    //�ĸ������߲�ͬ��˵���õ����߲�ͨ�� ������·
                    map[i][j]=3;//ͬһ��ջ�������ͬ����Ϊһ������
                    return false;
                }
            }else {
                //���map[i][j]!=0��������1,2,3
                return false;
            }
        }
    }
    //�޸Ĳ��ԣ��ĳ� �� �� �� ��
    public static boolean setWay2(int [][] map,int i,int j){
        if(map[6][5]==2){//ͨ·�Ѿ��ҵ�
            return  true;
        }else {
            if(map[i][j]==0){
                //�����ǰ��㻹û���߹������ղ�����
                map[i][j]=2;//���߹���Ȼ������һ��̽��
                if(setWay2(map,i-1,j)){//������
                    return true;
                }else if(setWay2(map,i,j+1)){//�����ߣ��߲�ͨ��������
                    return true;
                }else if(setWay2(map,i+1,j)){//�����ߣ��߲�ͨ��������
                    return true;
                }else if(setWay2(map,i,j-1)){//���ߣ��߲�ͨ��������
                    //������
                    return true;
                }else {
                    //�ĸ������߲�ͬ��˵���õ����߲�ͨ�� ������·
                    map[i][j]=3;//ͬһ��ջ�������ͬ����Ϊһ������
                    return false;
                }
            }else {
                //���map[i][j]!=0��������1,2,3
                return false;
            }
        }
    }
}
