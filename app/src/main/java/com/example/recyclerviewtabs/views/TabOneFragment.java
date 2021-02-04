package com.example.recyclerviewtabs.views;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewtabs.models.VerticalData;
import com.example.recyclerviewtabs.models.HorizontalData;
import com.example.recyclerviewtabs.adapters.VerticalAdapter;
import com.example.recyclerviewtabs.R;

import java.util.ArrayList;
import java.util.List;


public class TabOneFragment extends Fragment {

    public TabOneFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab_one, container, false);
        Context context = container.getContext();

        // added in first category
        List<HorizontalData> horizontalItem1 = new ArrayList<>();
        horizontalItem1.add(new HorizontalData("Kamikaze", "Eminem"));
        horizontalItem1.add(new HorizontalData("Under Press", "Logic"));
        horizontalItem1.add(new HorizontalData("KOD", "J. Chole"));
        horizontalItem1.add(new HorizontalData("Come & Go", "Juice WRLD"));
        horizontalItem1.add(new HorizontalData("The Box", "Roddy Rich"));

        // added in second category
        List<HorizontalData> horizontalItem2 = new ArrayList<>();
        horizontalItem2.add(new HorizontalData("1989", "Taylor Swift"));
        horizontalItem2.add(new HorizontalData("thank you, next", "Ariana Grande"));
        horizontalItem2.add(new HorizontalData("Emotions", "Carly"));
        horizontalItem2.add(new HorizontalData("Good Days", "SZA"));
        horizontalItem2.add(new HorizontalData("Tears", "The Weeknd"));

        // added in 3rd category
        List<HorizontalData> horizontalItem3 = new ArrayList<>();
        horizontalItem3.add(new HorizontalData("R.", "R Kelly"));
        horizontalItem3.add(new HorizontalData("Thriller", "Micheal Jackson"));
        horizontalItem3.add(new HorizontalData("Blonde", "Frank Ocean"));
        horizontalItem3.add(new HorizontalData("Needed Me", "Rihanna"));
        horizontalItem3.add(new HorizontalData("Distraction", "Kelhani"));

        List<VerticalData> verticalData = new ArrayList<>();
        verticalData.add(new VerticalData("Hip-Hop", horizontalItem1));
        verticalData.add(new VerticalData("Pop", horizontalItem2));
        verticalData.add(new VerticalData("R&B", horizontalItem3));

        VerticalAdapter verticalAdapter = new VerticalAdapter(context, verticalData);
        RecyclerView recyclerView = rootView.findViewById(R.id.verticalRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(verticalAdapter);
        return rootView;
    }

}