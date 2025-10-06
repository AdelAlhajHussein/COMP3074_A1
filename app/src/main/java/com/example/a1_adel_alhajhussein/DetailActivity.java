package com.example.a1_adel_alhajhussein;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static ArrayList<String> paymentHistory = new ArrayList<>();
    TextView tvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvHistory = findViewById(R.id.tvHistory);

        if (paymentHistory.isEmpty()) {
            tvHistory.setText("No payments yet");
        } else {
            StringBuilder allPayments = new StringBuilder();
            for (String record : paymentHistory) {
                allPayments.append(record).append("\n\n");
            }
            tvHistory.setText(allPayments.toString());
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // closes this activity and returns to MainActivity
        return true;
    }
}
