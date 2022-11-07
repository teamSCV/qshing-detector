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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Inspection_results extends AppCompatActivity
{
    Button QRscan_stop;
    Button Join_link;
    TextView link;
    TextView result;
    String[] url={"https://attsbcbell-104995.weeblysite.com/%22,%22https://guacharen.tk/web%22,%22","http://s.id/Verifica_BPER_web%22%7D"};  //링크 마지막에 /지워야 함
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_result);
        Intent intent = getIntent();
        String text=intent.getStringExtra("link");

        result=(TextView) findViewById(R.id.scan_result);
        link = (TextView) findViewById(R.id.qr_link) ;
        QRscan_stop= (Button)findViewById(R.id.close);
        Join_link= (Button)findViewById(R.id.join_site);
        link.setText("링크는"+text+"입니다.");
        for(int i=0;i<2;i++)
        {
            if(url[i].equals(text))
            {
                result.setText("해당 링크는 취약한 사이트 입니다.");
                break;
            }
            else
            {
                result.setText("해당 링크는 안전합니다.");
            }
        }
        QRscan_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        Join_link.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text));                      //qr주소를 인터넷으로 연결
                startActivity(intent);
            }
        });
    }
    public String readFile(String fileName) throws IOException
    {
        String filecontents="";
        try{
            InputStream iStream = openFileInput(fileName);
            if(iStream !=null)
            {
                InputStreamReader iStreamReader=new InputStreamReader(iStream);
                BufferedReader bufferedReader=new BufferedReader(iStreamReader);
                String temp="";
                StringBuffer sBuffer=new StringBuffer();
                while((temp= bufferedReader.readLine())!=null)
                {
                    sBuffer.append(temp);
                }
                iStream.close();
                filecontents=sBuffer.toString();

            }
        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return filecontents;
    }
}
