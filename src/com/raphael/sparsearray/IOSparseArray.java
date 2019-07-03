package com.raphael.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sparsearray
 * @date:2019/7/3
 */
public class IOSparseArray {
    public static void main(String[] args) {
        int arr[][]=new int [2][3];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;
        arr[1][0]=4;
        arr[1][1]=5;
        arr[1][2]=6;

        /***
         * 将数组保存到文件
         */
        FileOutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter=null;
        try {
            outputStream = new FileOutputStream(new File("C:\\Users\\Timmy\\Desktop\\tmp\\map.data"));
             outputStreamWriter =new OutputStreamWriter(outputStream);
            for(int i=0;i<2;i++)
                    outputStreamWriter.write(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]+"\n");
            outputStreamWriter.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 从文件读取数组
         */

        FileInputStream fileInputStream = null;
        String s =null;
        List<String>list =new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(new File("C:\\Users\\Timmy\\Desktop\\tmp\\map.data"));
            InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
            char c[]=new char[10000];
            while ((s=bufferedReader.readLine())!=null){
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width=(list.get(0)).split(" ").length;

        int arr2[][] = new int[list.size()][width];
        for (int i=0;i<list.size();i++){
            String s1= list.get(0);
            String a[]=s1.split(" ");
            for(int j=0;j<a.length;j++)
                arr2[i][j]= Integer.parseInt(a[j]);

        }

        for(int i=0;i<list.size();i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
