package com.example.neros.april6_assignment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int NEW_REST_REQUEST = 100;

    private ArrayList<Rest> restArrayList;
    private ArrayList<String> restNameArrayList; private ArrayAdapter<String> restNameAdapter;


    private LinearLayout mainLayout;
    private TextView restNumTextView;
    private ListView restNameListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("나의 맛집");

        varInitialize();
        setRestNameListView();
    }



    private void varInitialize() {
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        restNumTextView = (TextView)findViewById(R.id.restNumTextView);
        restNameListView = (ListView)findViewById(R.id.restNameListView);

        restArrayList = new ArrayList<Rest>();
        restNameArrayList = new ArrayList<String>();
    }
    private void setRestNameListView() {
        restNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, restNameArrayList);
        restNameListView.setAdapter(restNameAdapter);

        restNameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, RestInfoActivity.class);
                intent.putExtra("thisRest", restArrayList.get(position));
                startActivity(intent);
            }
        });

        restNameListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(mainLayout.getContext());
                dlg.setTitle("맛집 삭제").setIcon(R.mipmap.ic_launcher).setMessage(restNameArrayList.get(position) +" 맛집을 삭제하시겠습니까?")
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Snackbar.make(mainLayout, "맛집 삭제를 취소하였습니다.", Snackbar.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Snackbar.make(mainLayout, restNameArrayList.get(position) +" 맛집을 삭제하였습니다.", Snackbar.LENGTH_SHORT).show();
                            restArrayList.remove(position);
                            restNameArrayList.remove(position);
                            restNameAdapter.notifyDataSetChanged();
                            restNumTextView.setText("맛집리스트("+ String.valueOf(restArrayList.size()) +"개)");
                        }
                    });

                dlg.show();
                return true;
            }
        });
    }

    public void onClickAddRestBtn(View v){
        Intent intent = new Intent(this, NewRestActivity.class);
        startActivityForResult(intent, NEW_REST_REQUEST);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == NEW_REST_REQUEST){
            if(resultCode == RESULT_OK){
                Rest newRest = data.getParcelableExtra("newRest");
                restArrayList.add(newRest);
                restNameArrayList.add(newRest.getName());
                restNameAdapter.notifyDataSetChanged();
                restNumTextView.setText("맛집리스트("+ String.valueOf(restArrayList.size()) +"개)");
                Snackbar.make(mainLayout, "맛집이 추가되었습니다.", Snackbar.LENGTH_SHORT).show();
            }else if(resultCode == RESULT_CANCELED){
                Snackbar.make(mainLayout, "맛집 추가가 취소되었습니다.", Snackbar.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
