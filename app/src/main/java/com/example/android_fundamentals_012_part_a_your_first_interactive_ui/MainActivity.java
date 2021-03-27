package com.example.android_fundamentals_012_part_a_your_first_interactive_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_VALUE = "MainActivity.extras.integer_value";
    TextView tvValue;
    Integer value = 0;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_VALUE, value);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvValue = findViewById(R.id.tV_value);

        if (savedInstanceState != null)
        {
            value = savedInstanceState.getInt(EXTRA_VALUE);
            tvValue.setText(value.toString());
        }
    }

    public void MainActOnClick(View view) {

        switch (view.getId()){

            case R.id.btn_Toast:
                showToast();
                break;

            case R.id.btn_count:
                count();
                break;
        }

    }

    public void showToast()
    {
        Toast.makeText(this, "The current value is: " + tvValue.getText(), Toast.LENGTH_LONG).show();
    };

    public void count()
    {
        ++value;
        tvValue.setText(value.toString());
    };

}