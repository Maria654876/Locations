package com.example.locations.recycleview;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.locations.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView flagView;

    ViewHolder(View view) {
        super(view);
        flagView = view.findViewById(R.id.img);
    }
}
