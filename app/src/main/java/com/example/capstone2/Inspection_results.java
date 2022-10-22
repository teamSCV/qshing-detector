package com.example.capstone2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;

import org.w3c.dom.Text;

public class Inspection_results extends AppCompatActivity
{
    private Button QRscan_stop;
    private Button Join_link;
    private TextView link;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_result);
        Intent intent = getIntent();
        String text=intent.getStringExtra("link");
        link = (TextView) findViewById(R.id.qr_link) ;
        QRscan_stop= (Button)findViewById(R.id.close);
        Join_link= (Button)findViewById(R.id.join_site);
        link.setText(text);

//        QRscan_stop.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//            }
//        });
//        Join_link.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text));                      //qr주소를 인터넷으로 연결
//                startActivity(intent);
//            }
//        });
    }
}
