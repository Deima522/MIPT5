package com.example.mipt5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
    }

    @SuppressLint({"SetTextI18n", "StaticFieldLeak"})
    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("This might take a while...");
        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                tvContent.setText(result);
            }
        }.execute("USD");
    }
}