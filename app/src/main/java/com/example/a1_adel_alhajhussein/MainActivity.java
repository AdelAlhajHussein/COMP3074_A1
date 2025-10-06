package com.example.a1_adel_alhajhussein;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etHours, etRate;
    TextView tvResult;
    Button btnCalculate, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect layout views to Java
        etHours = findViewById(R.id.etHours);
        etRate = findViewById(R.id.etRate);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);

        // When Calculate is clicked
        btnCalculate.setOnClickListener(v -> calculatePay());

        // When Clear is clicked
        btnClear.setOnClickListener(v -> clearFields());
    }

    private void calculatePay() {
        String hoursStr = etHours.getText().toString().trim();
        String rateStr = etRate.getText().toString().trim();

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

    private void clearFields() {
        etHours.setText("");
        etRate.setText("");
        tvResult.setText("Result will appear here");
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.menu_history) {
            // Open the DetailActivity
            android.content.Intent intent = new android.content.Intent(this, DetailActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
