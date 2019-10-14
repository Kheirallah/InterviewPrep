package com.kheirallah.inc.queues;

//Hard
//Crack the coding interview 3.6

/*
An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at
the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create
the data structure to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure.

Example
    Input: 2, 9, 4, 5, 1 (Stack) (top to bottom)
    Output: 1, 2, 4, 5, 9 (Stack) (top to bottom)
 */

import java.util.LinkedList;

public class AnimalQueue {

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; //acts as timestamp

    public void enqueue(Animal a) {
        //Order is used as a sort of timestamp, so that we can compare the insertion order of a dog or a cat
        a.setOrder(order);
        order++;

        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeueAny() {
        //look at tops of dog and cat queue, and pop the queue with the oldest value
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    abstract class Animal {
        private int order;
        protected String name;

        public Animal(String n) {
            name = n;
        }

        public void setOrder(int ord) {
            order = ord;
        }

        public int getOrder() {
            return order;
        }

        //Compare orders of animals to return the older item.
        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    public class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    public class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }
}
