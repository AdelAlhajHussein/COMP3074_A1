package com.example.a1_adel_alhajhussein;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1_adel_alhajhussein.R;

public class MainActivity extends AppCompatActivity {

    EditText etHours, etRate;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHours = findViewById(R.id.etHours);
        etRate = findViewById(R.id.etRate);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> calculatePay());
    }

    private void calculatePay() {
        String hoursStr = etHours.getText().toString();
        String rateStr = etRate.getText().toString();

        if (hoursStr.isEmpty() || rateStr.isEmpty()) {
            Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double hours = Double.parseDouble(hoursStr);
        double rate = Double.parseDouble(rateStr);
        double regularPay, overtimePay = 0, totalPay, tax, netPay;

        if (hours > 40) {
            regularPay = 40 * rate;
            overtimePay = (hours - 40) * rate * 1.5;
        } else {
            regularPay = hours * rate;
        }

        totalPay = regularPay + overtimePay;
        tax = totalPay * 0.18;
        netPay = totalPay - tax;

        String result = String.format(
                "Regular Pay: $%.2f\nOvertime Pay: $%.2f\nTotal Pay: $%.2f\nTax (18%%): $%.2f\nNet Pay: $%.2f",
                regularPay, overtimePay, totalPay, tax, netPay
        );

        tvResult.setText(result);
    }
}
