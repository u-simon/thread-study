package com.simon.thread.thread.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author simon
 * @Date 2019-10-17 21:58
 */
public class Test1 {


    public static void main(String[] args) throws IOException {
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();

        pipedReader.connect(pipedWriter);
        new Thread(() -> {
            System.out.println("writer");

            try {
                for (int i = 0; i < 300; i++) {
                    pipedWriter.write(i + " ");
                    System.out.print(i + " ");
                }
                System.out.println();
                pipedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("read:");
            char[] chars = new char[20];
            int length = -1;
            try {
                while ((length = pipedReader.read(chars)) != -1) {
                    String s = new String(chars, 0, length);
                    System.out.print(s);
                }
                System.out.println();
                pipedReader.close();
            } catch (Exception e) {

            }

        }).start();
    }
}
