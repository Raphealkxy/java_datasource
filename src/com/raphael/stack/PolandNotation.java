package com.raphael.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.stack
 * @date:2019/7/20
 */
public class PolandNotation {

    public static void main(String[] args) {
        //�ȶ���һ���沨�����ʽ
        //��3+4����5 -6 =�� 3 4 + 5 �� 6 -
        //1.Ϊ�˷��㣬�沨�����ʽ�е����ֺͷ���ʹ�ÿո����
        String suffixExpression = "3 4 + 5 �� 6 -";
        //��һ�� �Ƚ�"3 4 + 5 �� 6 -";=���ŵ�ArrayList��
        //�ڶ��� ��ArrayList ���ݸ�һ������ ������ArrayList ���ջ��ɼ���

        List<String>rpnList = getListString(suffixExpression);
        System.out.println("rpnList"+rpnList);

        int res = calculate(rpnList);
        System.out.println("����Ľ����="+res);

    }
    //��һ���沨�����ʽ�����ν����ݺ������ ���뵽ArrayList��
    public static List<String>getListString(String suffixExpression){
        //��suffixExpression �ָ�
        String [] split = suffixExpression.split(" ");
        List<String>list = new ArrayList<String>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }

    //��ɶ��沨�����ʽ������
    /**
     *- ��������ɨ�裬��3��4ѹ���ջ
     * - ����+���������˵���4��3��4Ϊջ��Ԫ�أ�3λ�ζ�Ԫ�أ��������3+4��ֵ����7���ٽ�7��ջ��
     * - ��5��ջ
     * - �������ǡ����������˵���5��7�������7��5=35����35��ջ��
     * - ��6��ջ
     * - �����-������������35-6����29���ɴ˵ó����ս������ע�⣺ÿ�ε����������ڶ�������������ȥ��һ��������
     */

    public static int calculate(List<String>ls){
        //����һ��ջ ֻ��Ҫһ��ջ
       Stack<String>stack= new Stack<String>();
       //����ls
      for(String item:ls){
          //ʹ��һ��������ʽ��ȡ����

              if(item.matches("\\d+")){
                  //��ջ
                  stack.push(item);
              }else {
                 //pop�������� �����㣬����ջ
                  int num2 = Integer.parseInt(stack.pop());
                  int num1 = Integer.parseInt(stack.pop());
                  int res=0;
                  if(item.equals("+")){
                      res= num1+num2;
                  }else if(item.equals("-")){
                      res = num1-num2;
                  }else if(item.equals("��")){
                      res = num1*num2;
                  }else if(item.equals("/")){
                      res = num1/num2;
                  }else {
                      throw new RuntimeException("���������");
                  }
                  //��res��ջ
                  stack.push(res+"");
              }
          }

      //��� ����stack�е�����ʱ������
        return Integer.parseInt(stack.pop());
    }
}
