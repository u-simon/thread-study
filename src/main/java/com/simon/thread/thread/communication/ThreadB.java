package com.simon.thread.thread.communication;

/**
 * @Author simon
 * @Date 2019-09-10 22:09
 */
public class ThreadB extends  Thread {

    private MyList list;

    @Override
    public void run() {
        try {
           while (true){
               if (list.size() == 5){
                   System.out.println("数量 == 5了， 线程b要退出了");
                   throw new InterruptedException();
               }
           }
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    public ThreadB(MyList list) {
        this.list = list;
    }
}
