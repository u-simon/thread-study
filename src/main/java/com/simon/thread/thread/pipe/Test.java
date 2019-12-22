package com.simon.thread.thread.pipe;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author simon
 * @Date 2019-10-17 21:47
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedInputStream.connect(pipedOutputStream);
        new Thread(() -> {
            System.out.println("read:");
            byte[] bytes = new byte[20];
            try {
                int length = 0;
                while ((length = pipedInputStream.read(bytes)) != -1) {
                    String string = new String(bytes, 0, length);
                    System.out.print(string);
                }
                System.out.println();
                pipedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);

        new Thread(() -> {
            System.out.println("writer");

            try {
                for (int i = 0; i < 300; i++) {
                    pipedOutputStream.write((i + " ").getBytes());
                    System.out.print(i + " ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            try {
                pipedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
