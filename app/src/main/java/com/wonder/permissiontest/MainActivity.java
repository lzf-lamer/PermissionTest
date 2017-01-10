package com.wonder.permissiontest;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private Button bt_permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_permission = (Button)findViewById(R.id.bt_permission);
    }

    public void myOnClick(View view){
        List<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.CALL_PHONE);
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        requestRuntimePermission(permissions, new PermissionListener() {
            @Override
            public void granted() {
                Toast.makeText(MainActivity.this,"你棒棒哒哦！",Toast.LENGTH_LONG).show();
            }

            @Override
            public void denied(List<String> deniedPermission) {
                Toast.makeText(MainActivity.this,"请求失败!\n" + deniedPermission.size(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
