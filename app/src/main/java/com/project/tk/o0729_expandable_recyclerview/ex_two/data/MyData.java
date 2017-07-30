package com.project.tk.o0729_expandable_recyclerview.ex_two.data;

import java.util.ArrayList;
import java.util.List;

public class MyData {
    public int type;
    public String text;
    public List<MyData> inItems = new ArrayList<>();

    public MyData() {
    }

    public MyData(int type, String text) {
        this.type = type;
        this.text = text;
    }
}
