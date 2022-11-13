package com.example.readresourcefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg=(TextView) findViewById(R.id.txtMsg);
        String str="";
        StringBuffer buf= new StringBuffer();
        int fileResourceId= R.raw.file_to_read;
        InputStream inputStream = this.getResources().openRawResource(fileResourceId);
        BufferedReader reader = new BufferedReader( new InputStreamReader(inputStream) );
        if (inputStream!=null){
            while(true){
                try {
                    if (!((str=reader.readLine())!=null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                buf.append(str +"\n");
            }
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        txtMsg.setText(buf.toString());
    }
}