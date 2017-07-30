package com.project.tk.o0729_expandable_recyclerview.ex_basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.tk.o0729_expandable_recyclerview.R;
import com.project.tk.o0729_expandable_recyclerview.ex_basic.data.Item;

import java.util.ArrayList;
import java.util.List;

public class ExListBasic extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        itemList = new ArrayList<>();

        add(ExListAdapter.HEADER, "Fruits");
        add(ExListAdapter.CHILD, "Apple");
        add(ExListAdapter.CHILD, "Orange");
        add(ExListAdapter.CHILD, "Banana");
        add(ExListAdapter.HEADER, "Cars");
        add(ExListAdapter.CHILD, "Audi");
        add(ExListAdapter.CHILD, "Aston");
        add(ExListAdapter.CHILD, "BMW");
        add(ExListAdapter.CHILD, "Cadillac");


        Item item = new Item(ExListAdapter.HEADER, "Places");

        item.inItems = new ArrayList<>();
        item.inItems.add(new Item(ExListAdapter.CHILD, "Kerala"));
        item.inItems.add(new Item(ExListAdapter.CHILD, "Tamil"));
        item.inItems.add(new Item(ExListAdapter.CHILD, "Karnataka"));
        item.inItems.add(new Item(ExListAdapter.CHILD, "Maharashtra"));

        itemList.add(item);

        recyclerview.setAdapter(new ExListAdapter(this.itemList));
    }

    private void add(int type, String text){
        itemList.add(new Item(type,text));
    }
}
