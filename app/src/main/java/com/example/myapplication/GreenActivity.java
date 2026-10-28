package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GreenActivity extends AppCompatActivity {

    private EditText etGreen;
    private TextView tvMsg;
    private Button btnGoToBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green);

        etGreen = findViewById(R.id.etGreen);
        tvMsg = findViewById(R.id.tvMsg);
        btnGoToBlue = findViewById(R.id.btnGoToBlue);

        // 7. קליטת נתונים שהגיעו במסר מ-BlueActivity (אם קיימים)
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        if (data != null) {
            String message = data.getString("Message");
            if (message != null) {
                tvMsg.setText(message);
            }
        }

        // 5. רישום מאזין לכפתור מעבר ל-Blue
        btnGoToBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // קריאת ההודעה משדה הטקסט
                String message = etGreen.getText().toString();

                // יצירת מסר מפורש והוספת ההודעה
                Intent intentToBlue = new Intent(GreenActivity.this, BlueActivity.class);
                intentToBlue.putExtra("Message", message);

                // מעבר ל-BlueActivity
                startActivity(intentToBlue);
            }
        });
    }
}