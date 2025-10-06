package com.example.a1_adel_alhajhussein;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    // Shared list (holds payment history from MainActivity)
    public static ArrayList<String> paymentHistory = new ArrayList<>();

    ListView listViewHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Enable the back button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listViewHistory = findViewById(R.id.listViewHistory);

        // Create an ArrayAdapter to show each item in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paymentHistory
        );

        listViewHistory.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // go back to MainActivity
        return true;
    }
}
