package com.simon.thread.thread.communication;

/**
 * @Author simon
 * @Date 2019-09-10 22:07
 */
public class ThreadA extends Thread {
    private MyList list;

    @Override
    public void run() {
       try  {
           for (int i = 0; i < 10; i++){
               list.add();
               System.out.println("添加了" + (i + 1) + "个元素");
               Thread.sleep(1000);
           }
       } catch (Exception e){
           e.printStackTrace();
       }
    }

    public ThreadA(MyList list) {
        this.list = list;
    }
}
