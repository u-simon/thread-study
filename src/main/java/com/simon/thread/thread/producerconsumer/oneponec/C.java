package com.simon.thread.thread.producerconsumer.oneponec;

/**
 * @Author simon
 * @Date 2019-09-25 22:02
 */
public class C {

    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                if (ValueObject.value.equals("")){
                    lock.wait();
                }

                System.out.println("get的值是 " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
