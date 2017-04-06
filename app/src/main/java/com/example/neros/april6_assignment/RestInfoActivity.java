package com.example.neros.april6_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RestInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_info);

        setTitle("선택한 맛집 정보");
    }
}
