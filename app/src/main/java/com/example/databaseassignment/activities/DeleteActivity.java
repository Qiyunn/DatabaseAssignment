package com.example.databaseassignment.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.databaseassignment.R;
import com.example.databaseassignment.databases.DBHelper;

public class DeleteActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        editText=findViewById(R.id.edit_text_id);
        button=findViewById(R.id.button_submit);
        helper=new DBHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteUser(Integer.parseInt(editText.getText().toString()));
            }
        });

    }
}
