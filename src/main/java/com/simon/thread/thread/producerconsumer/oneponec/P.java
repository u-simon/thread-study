package com.simon.thread.thread.producerconsumer.oneponec;

/**
 * @Author simon
 * @Date 2019-09-25 21:54
 */
public class P {

    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized ((lock)){
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();

                System.out.println("set的信息是" + value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
