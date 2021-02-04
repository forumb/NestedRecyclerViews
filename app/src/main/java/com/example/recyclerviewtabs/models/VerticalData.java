package com.example.recyclerviewtabs.models;

import java.util.List;

public class VerticalData {

    String listTitle;
    List<HorizontalData> data;

    public VerticalData(String listTitle, List<HorizontalData> data) {
        this.listTitle = listTitle;
        this.data = data;
    }

    public String getListTitle() {
        return listTitle;
    }

    public List<HorizontalData> getData() {
        return data;
    }
}
