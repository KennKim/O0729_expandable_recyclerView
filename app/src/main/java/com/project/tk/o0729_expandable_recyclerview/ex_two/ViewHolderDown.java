package com.project.tk.o0729_expandable_recyclerview.ex_two;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.tk.o0729_expandable_recyclerview.R;
import com.project.tk.o0729_expandable_recyclerview.ex_two.data.MyData;

class ViewHolderDown extends RecyclerView.ViewHolder {
    public TextView tvChild;
    public MyData item;

    ViewHolderDown(View itemView) {
        super(itemView);
        tvChild = (TextView) itemView.findViewById(R.id.child_title);
    }
}