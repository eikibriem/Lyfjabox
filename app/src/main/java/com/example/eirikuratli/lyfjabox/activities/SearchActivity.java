package com.example.eirikuratli.lyfjabox.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eirkuratli.lyfjabox.R;

public class SearchActivity extends AppCompatActivity {
//TODO: create search that displays result in a list below, to be implemented and designed

    //Replaces the search that was intended in the HomeActivity. Uses recycler view. Here users can
    //search for medication that is available in the database. A click on a list item will open
    //MedicineInfoActivity.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
