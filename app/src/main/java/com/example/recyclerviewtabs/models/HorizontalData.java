package com.example.recyclerviewtabs.models;

public class HorizontalData {
    private String title;
    private String subtitle;
    private int noNumbers = -1;
    private int numbers = noNumbers;
    String gridText;


    public HorizontalData(String title, String subtitle){
        this.title = title;
        this.subtitle = subtitle;
    }

    public HorizontalData(int numbers){
        this.numbers = numbers;
    }

    public HorizontalData(String gridText){
        this.gridText = gridText;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getNumbers() {
        return numbers;
    }

    public boolean hasNumber() {
        return numbers != noNumbers;
    }

    public String getGridText() {
        return gridText;
    }
}
