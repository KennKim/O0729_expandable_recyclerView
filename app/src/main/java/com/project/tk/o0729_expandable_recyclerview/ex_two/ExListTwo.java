package com.project.tk.o0729_expandable_recyclerview.ex_two;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.tk.o0729_expandable_recyclerview.R;
import com.project.tk.o0729_expandable_recyclerview.ex_two.data.MyData;

import java.util.ArrayList;
import java.util.List;

public class ExListTwo extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<MyData> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        items = new ArrayList<>();
        recyclerview.setAdapter(new ExListTwoAdapter(this.items));

        initData();


    }

    private void initData(){


        MyData item = new MyData(ExListTwoAdapter.HEADER, "Places");
        item.inItems = new ArrayList<>();
        item.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Kerala"));
        item.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Tamil"));
        item.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Karnataka"));
        item.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Maharashtra"));

        items.add(item);



        MyData myData = new MyData(ExListTwoAdapter.HEADER,"two");
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Kerala"));
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Tamil"));
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Karnataka"));
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Maharashtra"));
        items.add(myData);



        items.add(makeData("make header"));

    }

    private MyData makeData(String header){
        MyData myData = new MyData(ExListTwoAdapter.HEADER,header);
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Kerala"));
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Tamil"));
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Karnataka"));
        myData.inItems.add(new MyData(ExListTwoAdapter.CHILD, "Maharashtra"));
        return myData;
    }


}
