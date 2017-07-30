package com.project.tk.o0729_expandable_recyclerview;

import java.util.List;

public class Item {
    public int type;
    public String text;
    public List<Item> inItems;

    public Item() {
    }

    public Item(int type, String text) {
        this.type = type;
        this.text = text;
    }
}
