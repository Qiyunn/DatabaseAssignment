package com.example.databaseassignment.activities;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.databaseassignment.R;
import com.example.databaseassignment.databases.DBHelper;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper helper;
    private EditText edit_id,edit_name,edit_phone,edit_address;
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        helper=new DBHelper(this);
        init();

    }

    private void init(){
        edit_id=findViewById(R.id.edit_text_id);
        edit_name=findViewById(R.id.edit_text_name);
        edit_phone=findViewById(R.id.edit_text_phone);
        edit_address=findViewById(R.id.edit_text_address);
        button=findViewById(R.id.button_submit);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        helper.addUser(Integer.parseInt(edit_id.getText().toString()),edit_name.getText().toString(),
                edit_phone.getText().toString(),edit_address.getText().toString());

    }
}
