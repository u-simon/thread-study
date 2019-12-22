package com.simon.thread.thread.communication;

/**
 * @Author simon
 * @Date 2019-09-10 22:11
 */
public class Test {
    public static void main(String[] args) {

        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(myList);
        threadB.setName("B");
        threadB.start();
    }
}
