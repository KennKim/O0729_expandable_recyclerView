package com.project.tk.o0729_expandable_recyclerview.ex_basic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.tk.o0729_expandable_recyclerview.R;
import com.project.tk.o0729_expandable_recyclerview.ex_basic.data.Item;

import java.util.ArrayList;
import java.util.List;

public class ExListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int HEADER = 0;
    static final int CHILD = 1;

    private List<Item> items;

    ExListAdapter(List<Item> data) {
        this.items = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        float dp = parent.getContext().getResources().getDisplayMetrics().density;
        int subItemPaddingLeft = (int) (18 * dp);
        int subItemPaddingTopAndBottom = (int) (5 * dp);
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_header, parent, false);
                return new ViewHolderHeader(view);
            case CHILD:
                LayoutInflater inflater1 = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater1.inflate(R.layout.list_child, parent, false);
                /*TextView itemTextView = new TextView(parent.getContext());
                itemTextView.setPadding(subItemPaddingLeft, subItemPaddingTopAndBottom, 0, subItemPaddingTopAndBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(itemTextView) {

                };*/
                return new ViewHolderChild(view);
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = items.get(position);
        switch (item.type) {
            case HEADER:
                final ViewHolderHeader listHeaderViewHolder = (ViewHolderHeader) holder;
                listHeaderViewHolder.item = item;
                listHeaderViewHolder.tvHeader.setText(item.text);
                if (item.inItems == null) {
                    listHeaderViewHolder.ivButton.setImageResource(R.drawable.circle_minus);
                } else {
                    listHeaderViewHolder.ivButton.setImageResource(R.drawable.circle_plus);
                }
                listHeaderViewHolder.ivButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.inItems == null) {
                            item.inItems = new ArrayList<Item>();
                            int count = 0;
                            int pos = items.indexOf(listHeaderViewHolder.item);
                            while (items.size() > pos + 1 && items.get(pos + 1).type == CHILD) {
                                item.inItems.add(items.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            listHeaderViewHolder.ivButton.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = items.indexOf(listHeaderViewHolder.item);
                            int index = pos + 1;
                            for (Item i : item.inItems) {
                                items.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            listHeaderViewHolder.ivButton.setImageResource(R.drawable.circle_minus);
                            item.inItems = null;
                        }
                    }
                });
                break;
            case CHILD:
                /*TextView itemTextView = (TextView) holder.itemView;
                itemTextView.setText(items.get(position).text);
                break;*/
                ViewHolderChild viewHolderChild = (ViewHolderChild)holder;
                viewHolderChild.tvChild.setText(items.get(position).text);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).type;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



}
