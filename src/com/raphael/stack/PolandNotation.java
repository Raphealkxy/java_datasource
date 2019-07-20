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
        //先定义一个逆波兰表达式
        //（3+4）×5 -6 =》 3 4 + 5 × 6 -
        //1.为了方便，逆波兰表达式中的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 × 6 -";
        //第一步 先将"3 4 + 5 × 6 -";=》放到ArrayList中
        //第二步 将ArrayList 传递给一个方法 ，遍历ArrayList 配合栈完成计算

        List<String>rpnList = getListString(suffixExpression);
        System.out.println("rpnList"+rpnList);

        int res = calculate(rpnList);
        System.out.println("计算的结果是="+res);

    }
    //将一个逆波兰表达式，依次将数据和运算符 放入到ArrayList中
    public static List<String>getListString(String suffixExpression){
        //将suffixExpression 分割
        String [] split = suffixExpression.split(" ");
        List<String>list = new ArrayList<String>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    /**
     *- 从左至右扫描，将3和4压入堆栈
     * - 遇到+运算符，因此弹出4和3（4为栈顶元素，3位次顶元素），计算出3+4的值，的7，再将7入栈。
     * - 将5入栈
     * - 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈。
     * - 将6入栈
     * - 最后是-运算符，计算出35-6，即29，由此得出最终结果。（注意：每次弹出两个，第二个弹出的数减去第一个弹出）
     */

    public static int calculate(List<String>ls){
        //创建一个栈 只需要一个栈
       Stack<String>stack= new Stack<String>();
       //遍历ls
      for(String item:ls){
          //使用一个正则表达式来取出数

              if(item.matches("\\d+")){
                  //入栈
                  stack.push(item);
              }else {
                 //pop出两个数 并运算，再入栈
                  int num2 = Integer.parseInt(stack.pop());
                  int num1 = Integer.parseInt(stack.pop());
                  int res=0;
                  if(item.equals("+")){
                      res= num1+num2;
                  }else if(item.equals("-")){
                      res = num1-num2;
                  }else if(item.equals("×")){
                      res = num1*num2;
                  }else if(item.equals("/")){
                      res = num1/num2;
                  }else {
                      throw new RuntimeException("运算符有误");
                  }
                  //把res入栈
                  stack.push(res+"");
              }
          }

      //最后 留在stack中的数据时运算结果
        return Integer.parseInt(stack.pop());
    }
}
