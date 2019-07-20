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

        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1.1+（（2+3）*4）-5 =》转成后缀
        //因为直接对str进行操作，不方便，因此先将 中缀表达式 转为基于string类型的list集合
        String expression ="1+((2+3)*4)-5";
       List<String>infixExpressionlist = toInfixExpresionList(expression);
        System.out.println(infixExpressionlist);
        //将得到的中缀表达式对应的list=》后缀表达式对应的list
         List<String>parseSuffixExpressionList= parseSuffixExpressionList(infixExpressionlist);
        System.out.println("后缀表达式对应的List"+parseSuffixExpressionList);




        //先定义一个逆波兰表达式
        //（3+4）×5 -6 =》 3 4 + 5 × 6 -
        //1.为了方便，逆波兰表达式中的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //第一步 先将"3 4 + 5 × 6 -";=》放到ArrayList中
        //第二步 将ArrayList 传递给一个方法 ，遍历ArrayList 配合栈完成计算

        List<String>rpnList = getListString(suffixExpression);
        System.out.println("rpnList"+rpnList);

        //int res = calculate(rpnList);
        //换成使用转换的结果的版本
        int res =calculate(parseSuffixExpressionList);
        System.out.println("计算的结果是="+res);

    }

    //将得到的中缀表达式对应的list=》后缀表达式对应的list
      public static List<String> parseSuffixExpressionList(List<String>ls){
        //定义两个栈
          Stack<String>s1 = new Stack<String>();//符号栈
          //因为s2这个栈 在整个转换过程中，没有pop操作 而且后面我们还需要逆序输出
          //因此比较麻烦，这里我们就不用Stack<String> 直接使用List<String>s2就可达到相同的效果 而且比用栈更方便操作
          List<String>s2 = new ArrayList<>() ;//存放中间结果 根据前面转换逻辑 从来没有弹出栈操作
          //遍历ls
          for(String item:ls){
              //如果是一个数，就加入s2
              if(item.matches("\\d+")){
                  s2.add(item);
              }else if (item.equals("(")){
                  s1.push(item);
              }else if(item.equals(")")){
                    //如果右括号），则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                  while (!s1.peek().equals("(")){//查看栈顶方法 但不弹出来
                      s2.add(s1.pop());
                  }
                  s1.pop();//将"( "也弹出 消除小括号
              }else {
                  //当item的优先级小于等于栈顶的优先级 就将s1栈顶的运算符弹出并加入s2中，再次转到4.1与s1中新的栈顶运算符相比较
                  //我们缺少一个比较优先级高低的方法
                  while(s1.size()!=0&&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                      s2.add(s1.pop());

                  }
                  //还需要将item压入栈中
                  s1.push(item);
              }
          }

          //需要将s1剩余的运算符一次弹出并加入s2
          while (s1.size()!=0){
              s2.add(s1.pop());
          }

          return s2;
      }
    //将中缀表达式 转成对应的list
    public static List<String>toInfixExpresionList(String s){
        //定义一个List。存放中缀表达式的对应的内容
        List<String>ls = new ArrayList<>();
        int i=0;//这是一个指针，用于遍历 中缀表达式字符串
        String str;//对多位数的拼接工作
        char c;//每遍历到一个字符，就放入到c
        do{
            //如果c是一个非数字，就需要加入到ls//ASCII 小于48 大于57 就不是一个数
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                     ls.add(""+c);
                     i++;
            }else{
                //如果是一个数 就需要考虑多位数的问题
                str="";//先将str置成“”
                while(i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
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
                  }else if(item.equals("*")){
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

//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation{
    private static int ADD =1;
    private static int SUB = 1;
    private static int MUL =2;
    private static  int DIV =2;
    //写一个静态方法，返回对应的优先级数字
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
                System.out.println("不存在该运算符");
                break;

        }

        return result;
    }
}