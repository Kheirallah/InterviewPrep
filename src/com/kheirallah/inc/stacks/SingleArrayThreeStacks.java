package com.kheirallah.inc.stacks;

//Easy
//Crack the coding interview 3.1

/*
Describe how you could use a single array to implement 3 stacks
 */

public class SingleArrayThreeStacks {

    class FixedMultiStack {
        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize) {
            this.stackCapacity = stackSize;
            values = new int[stackSize * numberOfStacks];
            sizes = new int[numberOfStacks];
        }

        public void push(int stackNum, int value) throws Exception {
            if (isFull(stackNum)) {
                throw new Exception("Cannot add to full stack");
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum) throws Exception {
            if (isEmpty(stackNum)) {
                throw new Exception("Cannot pop from empty stack");
            }
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }

        public int peek(int stackNum) throws Exception {
            if (isEmpty(stackNum)) {
                throw new Exception("Cannot peek into empty stack");
            }
            return values[indexOfTop(stackNum)];
        }

        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }
    }
}
