package com.simon.thread.thread.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author simon
 * @Date 2019-09-10 22:05
 */
public class MyList {
    private volatile List<String> list = new ArrayList<>();

    public void add(){
        list.add("simon");
    }

    public int size(){
        return list.size();
    }
}
