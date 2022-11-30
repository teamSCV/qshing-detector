package com.example.capstone2;

import androidx.appcompat.app.AppCompatActivity;
import com.example.capstone2.DataBaseHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.zxing.integration.android.IntentIntegrator;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button createQRBtn;
    private Button scanQRBtn;
    String val = null;
    TextView link_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        scanQRBtn = (Button) findViewById(R.id.scanQR);
        scanQRBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, ScanQR.class);
                startActivity(intent);
            }
        });


    }

}