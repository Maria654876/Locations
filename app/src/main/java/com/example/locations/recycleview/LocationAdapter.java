package com.example.locations.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locations.R;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Location> locations;

    public LocationAdapter(Context context, List<Location> locations) {
        this.inflater = LayoutInflater.from(context);
        this.locations = locations;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.img_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Location location = locations.get(position);
        holder.flagView.setImageResource(location.getImg());
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

}
