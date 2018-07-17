package com.ria.platnomorku.halaman.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ria.platnomorku.R;

/**
 * Created by meta on 17/07/18.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView textView, textView1;

    public ViewHolder(@NonNull View itemView, final KlikItem klikItem) {
        super(itemView);
        textView = itemView.findViewById(R.id.textview);
        textView1 = itemView.findViewById(R.id.textview1);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (klikItem != null) {
                    klikItem.klikItem(getAdapterPosition());
                }
            }
        });
    }
}