package com.example.neros.april6_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class NewRestActivity extends AppCompatActivity {

    private EditText nameEditText, telEditText, menu1EditText, menu2EditText, menu3EditText, homepageEditText;
    private RadioButton chickenRadioBtn, pizzaRadioBtn, hamburgerRadioBtn, buritoRadioBtn, sandwichRadioBtn, korchickenRadioBtn;

    private int checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_rest);

        setTitle("맛집 추가");
        varInitialize();
    }
    private void varInitialize() {
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        telEditText = (EditText)findViewById(R.id.telEditText);
        menu1EditText = (EditText)findViewById(R.id.menu1EditText);
        menu2EditText = (EditText)findViewById(R.id.menu2EditText);
        menu3EditText = (EditText)findViewById(R.id.menu3EditText);
        homepageEditText = (EditText)findViewById(R.id.homepageEditText);

        chickenRadioBtn = (RadioButton)findViewById(R.id.chickenRadioBtn);
        pizzaRadioBtn = (RadioButton)findViewById(R.id.pizzaRadioBtn);
        hamburgerRadioBtn = (RadioButton)findViewById(R.id.hamburgerRadioBtn);
        buritoRadioBtn = (RadioButton)findViewById(R.id.buritoRadioBtn);
        sandwichRadioBtn = (RadioButton)findViewById(R.id.sandwichRadioBtn);
        korchickenRadioBtn = (RadioButton)findViewById(R.id.korchickenRadioBtn);
    }

    public void onClickRadioBtn(View v){
        chickenRadioBtn.setChecked(false);
        pizzaRadioBtn.setChecked(false);
        hamburgerRadioBtn.setChecked(false);
        buritoRadioBtn.setChecked(false);
        sandwichRadioBtn.setChecked(false);
        korchickenRadioBtn.setChecked(false);

        RadioButton rb = (RadioButton) v;
        rb.setChecked(true);
        switch (rb.getId()){
            case R.id.chickenRadioBtn: checked = 0; break;
            case R.id.pizzaRadioBtn: checked = 1; break;
            case R.id.hamburgerRadioBtn: checked = 2; break;
            case R.id.buritoRadioBtn: checked = 3; break;
            case R.id.sandwichRadioBtn: checked = 4; break;
            case R.id.korchickenRadioBtn: checked = 5; break;
            default:
        }
    }

    public void onClickConfirmBtn(View v){
        if(nameEditText.getText().toString().equals("") ||
            telEditText.getText().toString().equals("") ||
            menu1EditText.getText().toString().equals("") ||
            menu2EditText.getText().toString().equals("") ||
            menu3EditText.getText().toString().equals("") ||
            homepageEditText.getText().toString().equals("") ||
            !(chickenRadioBtn.isChecked() ||
                pizzaRadioBtn.isChecked() ||
                hamburgerRadioBtn.isChecked() ||
                buritoRadioBtn.isChecked() ||
                sandwichRadioBtn.isChecked() ||
                korchickenRadioBtn.isChecked())) {
            Toast.makeText(this, "정보를 모두 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        Calendar calendar = Calendar.getInstance();

        String[] menu = {menu1EditText.getText().toString(), menu2EditText.getText().toString(), menu3EditText.getText().toString()};
        int[] regDate = {calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)};

        Rest newRest = new Rest(nameEditText.getText().toString(),
                                telEditText.getText().toString(),
                                menu[0], menu[1], menu[2],
                                homepageEditText.getText().toString(),
                                regDate[0], regDate[1], regDate[2],
                                checked);

        Intent intent = new Intent();
        intent.putExtra("newRest", newRest);
        setResult(RESULT_OK, intent);

        finish();
    }

    public void onClickCancelBtn(View v){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);

        finish();
    }


}
