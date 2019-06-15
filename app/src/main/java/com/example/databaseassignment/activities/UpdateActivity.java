package com.example.databaseassignment.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databaseassignment.R;
import com.example.databaseassignment.databases.DBHelper;

public class UpdateActivity extends AppCompatActivity {
    EditText editId,editName,editPhone,editAddrss;
    Button button;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        helper=new DBHelper(this);
        init();
    }

    private void init(){
        editId=findViewById(R.id.edit_text_id);
        editName=findViewById(R.id.edit_text_name);
        editPhone=findViewById(R.id.edit_text_phone);
        editAddrss=findViewById(R.id.edit_text_address);
        button=findViewById(R.id.button_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(editName.getText())){
                    helper.updateName(Integer.parseInt(editId.getText().toString()),editName.getText().toString());
                }else if(!TextUtils.isEmpty(editPhone.getText())){
                    helper.updatePhone(Integer.parseInt(editId.getText().toString()),editPhone.getText().toString());
                }else if(!TextUtils.isEmpty(editAddrss.getText())){
                    helper.updateAddress(Integer.parseInt(editId.getText().toString()),editAddrss.getText().toString());
                }else{
                    Log.i("hi","nothing changed");
                }
            }
        });
    }
}
