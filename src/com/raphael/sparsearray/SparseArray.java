package com.raphael.sparsearray;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sparsearray
 * @date:2019/7/3
 */
public class SparseArray {
    //创建一个原始的二维数组11*11
    //0：表示没有棋子，1表示黑子，2表示篮子
    public static void main(String[] args) {
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][4]=2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for(int [] row:chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组
        //1.先遍历二维数组 得到非0数据的个数
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++)
                if(chessArr1[i][j]!=0){
                    sum++;
                }
        }

        //2.创建对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];

        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组 将非0的值存放到稀疏数组中
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

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~");
        for(int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //将稀疏数组 恢复成原始的二维数组
        //先读取稀疏数组的第一行 根据第一行创建原始的二维数组 比如上面的chessArr2=int[11][11]
        //读取稀疏数组后 几行的数据 并赋给原始的二维数组


        int newArray[][]=new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i=1;i<=row;i++){
            newArray[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        System.out.println("打印读取出来的二维数组");

        for(int i=0;i<11;i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%d\t", newArray[i][j]);
            }
            System.out.println();
        }
    }




}
