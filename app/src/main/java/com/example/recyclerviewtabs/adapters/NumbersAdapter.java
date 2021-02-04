package com.example.recyclerviewtabs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtabs.R;
import com.example.recyclerviewtabs.models.HorizontalData;

import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.ViewHolder> {

    Context context;
    List<HorizontalData> data;

    public NumbersAdapter(@NonNull Context context, List<HorizontalData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public NumbersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_data, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull NumbersAdapter.ViewHolder holder, int position) {
        HorizontalData dataType = data.get(position);
        //Check if created for number constructor for tab three
        if (dataType.hasNumber()) {
            holder.text.setText(String.valueOf(dataType.getNumbers()));
            holder.text.setTextColor(context.getResources().getColor(R.color.blue));
        }
        //Check if created for string constructor for tab two grid view
        else {
            holder.text.setText(dataType.getGridText());
            holder.text.setBackgroundColor(context.getResources().getColor(R.color.white));
            holder.text.setTextSize(20);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
