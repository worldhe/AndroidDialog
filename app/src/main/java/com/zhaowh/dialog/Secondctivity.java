package com.zhaowh.dialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Secondctivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnColor;
    private TextView tvColor;
    private AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondctivity);
        btnColor = (Button) findViewById(R.id.btn_color);
        btnColor.setOnClickListener(this);
        tvColor = (TextView) findViewById(R.id.tv_color);
        initAlertDialog();
    }

    private void initAlertDialog(){
        alert = new AlertDialog.Builder(this);
        alert.setTitle("系统设置");
        alert.setIcon(R.mipmap.ic_launcher_round);
        alert.setItems(R.array.text_color, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        tvColor.setTextColor(Color.RED);
                        break;
                    case 2:
                        tvColor.setTextColor(Color.BLUE);
                        break;
                    case 1:
                        tvColor.setTextColor(Color.GREEN);
                        break;
                }
            }
        });
        alert.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_color:
                alert.show();
                break;
            default:
                break;
        }
    }
}
