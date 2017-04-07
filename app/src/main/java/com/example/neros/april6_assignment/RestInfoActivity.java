package com.example.neros.april6_assignment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RestInfoActivity extends AppCompatActivity {

    private TextView restNameTextView, menu1TextView, menu2TextView, menu3TextView, telTextView, homepageTextView, regDateTextView;
    private ImageView categoryImageView;

    private Rest thisRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_info);

        setTitle("선택한 맛집 정보");

        varInitialize();
        getRest();
        showRest(thisRest);
    }

    private void varInitialize() {
        restNameTextView = (TextView) findViewById(R.id.restNameTextView);
        menu1TextView = (TextView) findViewById(R.id.menu1TextView);
        menu2TextView = (TextView) findViewById(R.id.menu2TextView);
        menu3TextView = (TextView) findViewById(R.id.menu3TextView);
        telTextView = (TextView) findViewById(R.id.telTextView);
        homepageTextView = (TextView) findViewById(R.id.homepageTextView);
        regDateTextView = (TextView) findViewById(R.id.regDateTextView);

        categoryImageView = (ImageView) findViewById(R.id.categoryImageView);
    }

    private void getRest() {
        Intent intent = getIntent();
        thisRest = intent.getParcelableExtra("thisRest");
    }

    private void showRest(Rest thisRest) {
        /*
        public int getCategory(){ return this.category; }*/

        restNameTextView.setText(thisRest.getName());
        menu1TextView.setText(thisRest.getMenu1());
        menu2TextView.setText(thisRest.getMenu2());
        menu3TextView.setText(thisRest.getMenu3());
        telTextView.setText(thisRest.getPhone());
        homepageTextView.setText(thisRest.getHomepage());

        regDateTextView.setText(String.valueOf(thisRest.getYear()) + "년 " + String.valueOf(thisRest.getMonth()) + "월 " + String.valueOf(thisRest.getDay() + "일"));

        switch (thisRest.getCategory()) {
            case 0:
                categoryImageView.setImageResource(R.drawable.chicken);
                break;
            case 1:
                categoryImageView.setImageResource(R.drawable.pizza);
                break;
            case 2:
                categoryImageView.setImageResource(R.drawable.hamburger);
                break;
            case 3:
                categoryImageView.setImageResource(R.drawable.burito);
                break;
            case 4:
                categoryImageView.setImageResource(R.drawable.sandwich);
                break;
            case 5:
                categoryImageView.setImageResource(R.drawable.korchicken);
                break;

            default:
        }
    }

    public void onClickCallBtn(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ thisRest.getPhone()));
        startActivity(intent);
    }
    public void onClickHomePageBtn(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(thisRest.getHomepage()));
        startActivity(intent);
    }

    public void onClickBackBtn(View v){
        finish();
    }
}
