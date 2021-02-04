package com.example.recyclerviewtabs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtabs.models.HorizontalData;
import com.example.recyclerviewtabs.models.VerticalData;
import com.example.recyclerviewtabs.R;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    Context context;
    List<VerticalData> data;

    public VerticalAdapter(Context context, List<VerticalData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VerticalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_list, parent, false);
        return new VerticalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalAdapter.ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getListTitle());
        setHorizontalList(holder.recyclerView, data.get(position).getData());
    }

    private void setHorizontalList(RecyclerView recyclerView, List<HorizontalData> data) {
        String page = "one";
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(context, data, page);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(horizontalAdapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.header);
            recyclerView = itemView.findViewById(R.id.horzRv);

        }
    }
}

