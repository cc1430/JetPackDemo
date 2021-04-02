package com.android.my.jetpack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android.my.jetpack.R;
import com.android.my.jetpack.databinding.TitleItemBindingImpl;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder> {

    TitleItemBindingImpl titleItemBinding;
    LayoutInflater inflate;
    List<String> itemList;
    ItemClickListener listener;

    public interface ItemClickListener{
        void OnItemClick(View view, int position);
    }

    public ItemListAdapter(Context context, List<String> data) {
        this.inflate = LayoutInflater.from(context);
        this.itemList = data;
    }

    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        titleItemBinding = DataBindingUtil.inflate(inflate, R.layout.title_item, parent, false);
        return new MyViewHolder(titleItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.MyViewHolder holder, int position) {
        titleItemBinding.tvTitle.setText(itemList.get(position));
        titleItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.OnItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
