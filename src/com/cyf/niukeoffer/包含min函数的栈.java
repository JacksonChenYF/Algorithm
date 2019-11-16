package com.cyf.niukeoffer;

import java.util.Stack;

/**
 * @Auther: ChenYF
 * @Date: 2019/9/30 18:20
 * @Description:定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数 （时间复杂度应为O（1））。
 */
public class 包含min函数的栈 {

    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stackData.push(node);
        if (stackMin.isEmpty() || min() > node) {
            stackMin.push(node);
        } else {
            stackMin.push(min()); //若弹出的元素为最小值，则最小栈中的值也得一起弹
        }
    }

    public void pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("栈为空，无最小值！ ");
        }
        return stackMin.peek();
    }
}



