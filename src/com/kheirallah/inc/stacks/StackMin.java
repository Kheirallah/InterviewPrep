package com.kheirallah.inc.stacks;

//Easy
//Crack the coding interview 3.2

/*
How would you design a stack which in addition to push and pop, has a function min which returns the minimum element? Push, pop, and min should all operate in O(1) time.

Example:
    push(5); stack is {5}, min is 5
    push(6); stack is {6, 5}, min is 5
    push(3); stack is {3, 6, 5}, min is 3
    push(7); stack is {7, 3, 6, 5}, min is 3
    pop(); pops 7. stack is {3, 6, 5}, min is  3
    pop(); pops 3. stack is {6, 5}, min is  5
 */

import java.util.Stack;

public class StackMin extends Stack<StackMin.NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));

    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MIN_VALUE; //error
        } else {
            NodeWithMin n = peek();
            return n.min;
        }
    }

    class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
