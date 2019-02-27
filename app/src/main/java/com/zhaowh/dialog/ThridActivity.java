package com.zhaowh.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThridActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIconList;
    private AlertDialog.Builder builder;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> list;
    private Map<String, Object> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        btnIconList = (Button) findViewById(R.id.btn_icon_list);
        btnIconList.setOnClickListener(this);
        initAlertDialog();
    }

    private void initAlertDialog(){
        list = new ArrayList<Map<String, Object>>();
        String[] settingName = getResources().getStringArray(R.array.text_set_name);
        String[] settingIcon = getResources().getStringArray(R.array.text_set_icon);
        Log.d("ThridActivity", "------>initAlertDialog: name   "+settingName);
        Log.d("ThridActivity", "------>initAlertDialog: icon   "+settingIcon);
        for(int i = 0; i< settingName.length; i++){
            map = new HashMap<String, Object>();
            map.put("setting",settingName[i]);
            map.put("icon",getResources().getIdentifier(settingIcon[i], "drawable", getPackageName()));
            list.add(map);
        }

        adapter = new SimpleAdapter(this, list, R.layout.simple_item,
                new String[]{"setting","icon"},
                new int[]{R.id.tv_item, R.id.iv_item});
        builder = new AlertDialog.Builder(this);
        builder.setTitle("系统设置列表");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                switch (which){
                    case 0:
                        intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        break;
                    case 1:
                        intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                        break;
                    case 2:
                        intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        });
        builder.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_icon_list:
                builder.show();
                break;
            default:
                break;
        }
    }
}
