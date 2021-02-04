package com.example.recyclerviewtabs.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtabs.models.HorizontalData;
import com.example.recyclerviewtabs.views.OnClickActivity;
import com.example.recyclerviewtabs.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    Context context;
    List<HorizontalData> data;
    String page;

    public HorizontalAdapter(Context context, List<HorizontalData> data, String page) {
        this.context = context;
        this.data = data;
        this.page = page;
    }

    @NonNull
    @Override
    public HorizontalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_list, parent, false);
        if(page.equalsIgnoreCase("first")){
            view.setBackgroundColor(context.getResources().getColor(R.color.yellow));
        }
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter.ViewHolder holder, int position) {
        HorizontalData data1 = data.get(position);
        holder.title.setText(data1.getTitle());
        holder.subtitle.setText(data1.getSubtitle());

        if(page.equalsIgnoreCase("two")) {
            holder.linearLayout.setBackgroundResource(R.drawable.list_circle);
            String title = data1.getTitle();
            GradientDrawable linearLayoutBackground = (GradientDrawable) holder.linearLayout.getBackground();
            int color = getBackgroundColor(title);
            linearLayoutBackground.setColor(color);

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subtitle;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            linearLayout = itemView.findViewById(R.id.horizontalLinearLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HorizontalData data1 = data.get(getAdapterPosition());
                    String title = data1.getTitle();
                    String subtitle = data1.getSubtitle();
                    //Create json and send to OnClick activity
                    String jsonStr = createJSON(title, subtitle);
                    Intent intent = new Intent(context, OnClickActivity.class);
                    intent.putExtra("JSON", jsonStr);
                    context.startActivity(intent);
                }
            });
        }
    }

    private int getBackgroundColor(String title) {
        int horizontalColorResourceId;

        switch (title) {
            case "Intersteller":
                horizontalColorResourceId = R.color.listBackground1;
                break;
            case "Avenger":
                horizontalColorResourceId = R.color.listBackground2;
                break;
            case "Coco":
                horizontalColorResourceId = R.color.listBackground3;
                break;
            case "Thor":
                horizontalColorResourceId = R.color.listBackground4;
                break;
            case "Love":
                horizontalColorResourceId = R.color.listBackground5;
                break;
            default:
                horizontalColorResourceId = R.color.listBackground6;
                break;


        }
        return ContextCompat.getColor(context, horizontalColorResourceId);
    }

    private String createJSON(String title, String subtitle) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Title", title);
            jsonObject.put("Subtitle", subtitle);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        return jsonArray.toString();

    }
}
