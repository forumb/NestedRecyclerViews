package com.example.recyclerviewtabs.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewtabs.adapters.NumbersAdapter;
import com.example.recyclerviewtabs.R;
import com.example.recyclerviewtabs.adapters.HorizontalAdapter;
import com.example.recyclerviewtabs.models.HorizontalData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TabTwoFragment extends Fragment {

    public TabTwoFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_tab_two, container, false);
        String page = "two";

        RecyclerView recyclerView = rootView.findViewById(R.id.headerRV);
        // added in first category
        List<HorizontalData> horizontalData = new ArrayList<>();
        horizontalData.add(new HorizontalData("Intersteller", "Sci-Fi"));
        horizontalData.add(new HorizontalData("Avenger", "Action"));
        horizontalData.add(new HorizontalData("Coco", "Comedy"));
        horizontalData.add(new HorizontalData("Thor", "Action"));
        horizontalData.add(new HorizontalData("Love", "Romance"));

        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(getActivity(), horizontalData, page);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(horizontalAdapter);

        RecyclerView recyclerView2 = rootView.findViewById(R.id.gridRV);
        ArrayList<HorizontalData> gridData = new ArrayList<>();
        gridData.add(new HorizontalData("Learn from the mistakes of others. You can't live long enough to make them all yourself"));
        gridData.add(new HorizontalData("Once you choose hope, anything’s possible"));
        gridData.add(new HorizontalData("It is not how much we have, but how much we enjoy, that makes happiness"));
        gridData.add(new HorizontalData("Her beauty is laced in her strength and interwoven through her flaws. She embodies perfection"));
        gridData.add(new HorizontalData("Unshakable faith shakes up everything!"));
        gridData.add(new HorizontalData("I live for the moments I dare to be me inspite of all that I \"should\" be"));
        gridData.add(new HorizontalData("Unshakable faith shakes up everything!"));
        gridData.add(new HorizontalData("I live for the moments I dare to be me inspite of all that I \"should\" be"));

        NumbersAdapter numbersAdapter = new NumbersAdapter(Objects.requireNonNull(getActivity()), gridData);
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView2.setAdapter(numbersAdapter);

        return rootView;
    }

}