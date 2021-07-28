package com.example.amazonclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> imageUrls = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initNavBarRV(int rView, int listItemRV) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(rView);
        recyclerView.setLayoutManager(layoutManager);
        NavBarRVAdapter adapter = new NavBarRVAdapter(imageUrls, names, this, listItemRV);
        recyclerView.setAdapter(adapter);
    }

    private void initPrimeDealsRV(int rView, int listItemRV) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(rView);
        recyclerView.setLayoutManager(layoutManager);
        PrimeDealsRVAdapter adapter = new PrimeDealsRVAdapter(imageUrls, names, this, listItemRV);
        recyclerView.setAdapter(adapter);
    }
}