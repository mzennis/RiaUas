package com.ria.platnomorku.halaman.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ria.platnomorku.R;
import com.ria.platnomorku.database.DataPlatNomor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meta on 10/07/18.
 */
public class PlatNomorAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<DataPlatNomor> list = new ArrayList<>();

    protected KlikItem klikItem;

    public void setKlikItem(KlikItem klikItem) {
        this.klikItem = klikItem;
    }

    public PlatNomorAdapter() { }

    public void addAll(List<DataPlatNomor> list) {
        this.list.addAll(list);
    }

    public void clear() {
        this.list.clear();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(getView(viewGroup, i), klikItem);
    }

    protected View getView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DataPlatNomor item = list.get(i);
        viewHolder.textView.setText(item.getKode());
        viewHolder.textView1.setText(item.getKota());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public DataPlatNomor getItem(int position) {
        return list.get(position);
    }
}
