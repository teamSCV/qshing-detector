package com.example.capstone2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Inspection_results extends AppCompatActivity {
    Button QRscan_stop;
    Button Join_link;
    TextView link;
    TextView result;
    String text;
    String[] url = {};  //링크 마지막에 /지워야 함
    private Object String;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_result);
        Intent intent = getIntent();
        text = intent.getStringExtra("link");

        result = (TextView) findViewById(R.id.scan_result);
        link = (TextView) findViewById(R.id.qr_link);
        QRscan_stop = (Button) findViewById(R.id.close);
        Join_link = (Button) findViewById(R.id.join_site);
        link.setText("링크는" + text + "입니다.");
//        try {
//
//            InputStreamReader is = new InputStreamReader(getResources().openRawResource(R.raw.badsite));
//            BufferedReader reader = new BufferedReader(is);
//            CSVReader read = new CSVReader(reader);
//            String record;
//            int link_count = 0;
//            while ((record = read.readNext()) != null) {
//                url[link_count] = record;
//                if (url[link_count].equals(text))                            // qrcode랑 링크랑 같다면
//                {
//                    result.setText("해당 링크는 취약한 사이트 입니다.");
//                    break;
//                } else {
//                    link_count++;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        result.setText("해당 링크는 안전합니다.");

        QRscan_stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        Join_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text));                      //qr주소를 인터넷으로 연결
                startActivity(intent);
            }
        });
    }
}
