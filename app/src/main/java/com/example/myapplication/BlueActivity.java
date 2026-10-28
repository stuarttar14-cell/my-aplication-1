package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BlueActivity extends AppCompatActivity {

    private EditText etBlue;
    private TextView tvMsg;
    private Button btnGoToGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue);

        etBlue = findViewById(R.id.etBlue);
        tvMsg = findViewById(R.id.tvMsg);
        btnGoToGreen = findViewById(R.id.btnGoToGreen);

        // 6. א. קליטת הנתונים שהגיעו במסר מ-GreenActivity בעזרת המפתח "Message"
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        if (data != null) {
            String message = data.getString("Message");
            if (message != null) {
                // 6. ב. כתיבת ההודעה על המסך
                tvMsg.setText(message);
            }
        }

        // 6. ג + ד. רישום מאזין ושליחת ההודעה חזרה ל-GreenActivity
        btnGoToGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = etBlue.getText().toString();

                Intent intentToGreen = new Intent(BlueActivity.this, GreenActivity.class);
                intentToGreen.putExtra("Message", message);

                startActivity(intentToGreen);
            }
        });
    }
}