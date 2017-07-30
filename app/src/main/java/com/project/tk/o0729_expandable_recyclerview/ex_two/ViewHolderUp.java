package com.project.tk.o0729_expandable_recyclerview.ex_two;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.tk.o0729_expandable_recyclerview.R;
import com.project.tk.o0729_expandable_recyclerview.ex_two.data.MyData;


class ViewHolderUp extends RecyclerView.ViewHolder {
    public TextView tvHeader;
    public ImageView ivButton;
    public MyData item;

    ViewHolderUp(View itemView) {
        super(itemView);
        tvHeader = (TextView) itemView.findViewById(R.id.header_title);
        ivButton = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
    }
}