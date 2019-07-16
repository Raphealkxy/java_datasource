package com.raphael.stack;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.stack
 * @date:2019/7/16
 */
public class Calculator {
    public static void main(String[] args) {
            //������д���ʽ������
        String expression = "3+2*9-2";
        //��������ջ����ջ��һ������ջ
        ArrayStack2  numStack =new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //������Ҫ����ر���
        int index = 0;//����ɨ��
        int num1 = 0;
        int num2 = 0;
        int oper  = 0;
        int res = 0;
        char ch =' ';//��ÿ��ɨ��õ�char���浽ch
        //��ʼwhileѭ����ɨ��expression
        while(true){
            //���εõ�expression
            ch = expression.substring(index,index+1).charAt(0);//�����ַ��� �����ַ���ֻ��һ���ַ� �ó�
            //�ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
            if(operStack.isOper(ch)){//����������
                //�жϵ�ǰ�ķ���ջ�Ƿ�Ϊ��
                if(!operStack.isEmpty()){
                    //�������ջ�в��������ͽ��бȽϣ������ǰ�ķ��ŵ����ȼ�С�ڻ��ߵ���ջ�еĲ��������ͽ�������Ĳ���
                    //�ڴӷ���ջ��pop��һ�����ţ��������㣬���õ����������ջ��Ȼ�󽫵�ǰ�Ĳ����������ջ
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 =numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //������ṹ����ջ
                        numStack.push(res);
                        //Ȼ�󽫵�ǰ�Ĳ����������ջ
                        operStack.push(ch);
                    }else {
                        //�����ǰ�Ĳ����������ȼ�����ջ�еĲ���������ֱ�������ջ
                        operStack.push(ch);
                    }

                }else {
                    //Ϊ�� ֱ����ջ
                    operStack.push(ch);//1+3
                }
            }else {
                //������� ֱ������ջ
                numStack.push(ch-48);//? "1+3" //�ַ�1 ʮ���ƶ�Ӧ49 ת������1 49-48 �Դ�����
            }
            //��index+1 ���ж��Ƿ�ɨ�赽expression���
            index++;
            if(index>=expression.length()){
                break;
            }
        }

            //�����ʽɨ����� ��˳��Ĵ���ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������
        while(true){
            //�������ջΪ�գ����㵽���Ľ������ջ��ֻ��һ�����
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        //����ջ���������pop��
        System.out.printf("���ʽ�Ľ����%s=%d",expression,numStack.pop());
    }
}
//�ȴ���һ��ջ��ֱ��ʹ��ǰ�洴���õ�
//����һ���� ArrayStack2 ��ʾջ����Ҫ��չ����
class ArrayStack2 {
    private int maxSize;//ջ��С
    private int[] stack;//���飬����ģ��ջ�����ݷ�������
    private int top = -1;//top��ʾջ������ʼ��Ϊ-1��

    //������
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //����һ������ ���Է��ص�ǰջ����ֵ ������������pop
    public int peek(){
        return stack[top];
    }
    //ջ�� top = maxSize-1 ջ��

    public boolean isFull() {
        return top == maxSize - 1;
    }

    //ջ��
    public boolean isEmpty() {
        return top == -1;
    }

    //��ջ push
    public void push(int value) {
        //���ж�ջ��
        if (isFull()) {
            System.out.println("ջ��");
            return;
        }
        top++;
        stack[top] = value;
    }

    //��ջ
    public int pop() {
        //��ջ�������ݷ���
        if (isEmpty()) {
            throw new RuntimeException("ջΪ��");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //����ջ ����ʱ��Ҫ��ջ����ʼ��ʾ����
    public void list() {
        if (isEmpty()) {
            System.out.println("ջ�գ�û������");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //��������������ȼ������ȼ��ǳ���Աȷ�������ȼ�ʹ�����ֱ�ʾ������Խ�������ȼ�Խ��
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//�ٶ�Ŀǰ���ʽֻ��+��-��*��/
        }
    }

    //�ж��ǲ���һ������� //Ҫô�������Ҫô����
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //���㷽��
    public int cal(int num1, int num2, int oper) {
        int result = 0;//���ڴ�ż���Ľ��
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;//ע��˳��
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;

        }
        return result;
    }

}