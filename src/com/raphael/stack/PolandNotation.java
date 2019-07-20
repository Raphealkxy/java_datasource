package com.raphael.stack;

import java.util.AbstractList;
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

        //��ɽ�һ����׺���ʽת�ɺ�׺���ʽ�Ĺ���
        //˵��
        //1.1+����2+3��*4��-5 =��ת�ɺ�׺
        //��Ϊֱ�Ӷ�str���в����������㣬����Ƚ� ��׺���ʽ תΪ����string���͵�list����
        String expression ="1+((2+3)*4)-5";
       List<String>infixExpressionlist = toInfixExpresionList(expression);
        System.out.println(infixExpressionlist);
        //���õ�����׺���ʽ��Ӧ��list=����׺���ʽ��Ӧ��list
         List<String>parseSuffixExpressionList= parseSuffixExpressionList(infixExpressionlist);
        System.out.println("��׺���ʽ��Ӧ��List"+parseSuffixExpressionList);




        //�ȶ���һ���沨�����ʽ
        //��3+4����5 -6 =�� 3 4 + 5 �� 6 -
        //1.Ϊ�˷��㣬�沨�����ʽ�е����ֺͷ���ʹ�ÿո����
        String suffixExpression = "3 4 + 5 * 6 -";
        //��һ�� �Ƚ�"3 4 + 5 �� 6 -";=���ŵ�ArrayList��
        //�ڶ��� ��ArrayList ���ݸ�һ������ ������ArrayList ���ջ��ɼ���

        List<String>rpnList = getListString(suffixExpression);
        System.out.println("rpnList"+rpnList);

        //int res = calculate(rpnList);
        //����ʹ��ת���Ľ���İ汾
        int res =calculate(parseSuffixExpressionList);
        System.out.println("����Ľ����="+res);

    }

    //���õ�����׺���ʽ��Ӧ��list=����׺���ʽ��Ӧ��list
      public static List<String> parseSuffixExpressionList(List<String>ls){
        //��������ջ
          Stack<String>s1 = new Stack<String>();//����ջ
          //��Ϊs2���ջ ������ת�������У�û��pop���� ���Һ������ǻ���Ҫ�������
          //��˱Ƚ��鷳���������ǾͲ���Stack<String> ֱ��ʹ��List<String>s2�Ϳɴﵽ��ͬ��Ч�� ���ұ���ջ���������
          List<String>s2 = new ArrayList<>() ;//����м��� ����ǰ��ת���߼� ����û�е���ջ����
          //����ls
          for(String item:ls){
              //�����һ�������ͼ���s2
              if(item.matches("\\d+")){
                  s2.add(item);
              }else if (item.equals("(")){
                  s1.push(item);
              }else if(item.equals(")")){
                    //��������ţ��������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
                  while (!s1.peek().equals("(")){//�鿴ջ������ ����������
                      s2.add(s1.pop());
                  }
                  s1.pop();//��"( "Ҳ���� ����С����
              }else {
                  //��item�����ȼ�С�ڵ���ջ�������ȼ� �ͽ�s1ջ�������������������s2�У��ٴ�ת��4.1��s1���µ�ջ���������Ƚ�
                  //����ȱ��һ���Ƚ����ȼ��ߵ͵ķ���
                  while(s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                      s2.add(s1.pop());

                  }
                  //����Ҫ��itemѹ��ջ��
                  s1.push(item);
              }
          }

          //��Ҫ��s1ʣ��������һ�ε���������s2
          while (s1.size()!=0){
              s2.add(s1.pop());
          }

          return s2;
      }
    //����׺���ʽ ת�ɶ�Ӧ��list
    public static List<String>toInfixExpresionList(String s){
        //����һ��List�������׺���ʽ�Ķ�Ӧ������
        List<String>ls = new ArrayList<>();
        int i=0;//����һ��ָ�룬���ڱ��� ��׺���ʽ�ַ���
        String str;//�Զ�λ����ƴ�ӹ���
        char c;//ÿ������һ���ַ����ͷ��뵽c
        do{
            //���c��һ�������֣�����Ҫ���뵽ls//ASCII С��48 ����57 �Ͳ���һ����
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                     ls.add(""+c);
                     i++;
            }else{
                //�����һ���� ����Ҫ���Ƕ�λ��������
                str="";//�Ƚ�str�óɡ���
                while(i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;//ƴ��
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
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
                  }else if(item.equals("*")){
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

//��дһ���� Operation ���Է���һ������� ��Ӧ�����ȼ�
class Operation{
    private static int ADD =1;
    private static int SUB = 1;
    private static int MUL =2;
    private static  int DIV =2;
    //дһ����̬���������ض�Ӧ�����ȼ�����
    public static int getValue(String operation){
        int result =0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("�����ڸ������");
                break;

        }

        return result;
    }
}