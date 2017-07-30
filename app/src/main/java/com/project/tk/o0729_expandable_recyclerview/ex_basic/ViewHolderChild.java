package com.project.tk.o0729_expandable_recyclerview.ex_basic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.tk.o0729_expandable_recyclerview.R;
import com.project.tk.o0729_expandable_recyclerview.ex_basic.data.Item;

class ViewHolderChild extends RecyclerView.ViewHolder {
    public TextView tvChild;
    public Item item;

    ViewHolderChild(View itemView) {
        super(itemView);
        tvChild = (TextView) itemView.findViewById(R.id.child_title);
    }
}