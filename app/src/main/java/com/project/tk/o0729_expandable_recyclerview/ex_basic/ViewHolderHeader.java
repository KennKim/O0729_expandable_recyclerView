package com.project.tk.o0729_expandable_recyclerview.ex_basic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.tk.o0729_expandable_recyclerview.R;
import com.project.tk.o0729_expandable_recyclerview.ex_basic.data.Item;


class ViewHolderHeader extends RecyclerView.ViewHolder {
    public TextView tvHeader;
    public ImageView ivButton;
    public Item item;

    ViewHolderHeader(View itemView) {
        super(itemView);
        tvHeader = (TextView) itemView.findViewById(R.id.header_title);
        ivButton = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
    }
}