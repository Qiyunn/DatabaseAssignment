package com.example.databaseassignment.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.databaseassignment.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_insert,button_update,button_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        button_insert=findViewById(R.id.button_insert);
        button_update=findViewById(R.id.button_update);
        button_delete=findViewById(R.id.button_delete);
        button_insert.setOnClickListener(this);
        button_update.setOnClickListener(this);
        button_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_insert:
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
                break;
            case R.id.button_update:
                startActivity(new Intent(MainActivity.this,UpdateActivity.class));
                break;
            case R.id.button_delete:
                startActivity(new Intent(MainActivity.this,DeleteActivity.class));
                break;

        }
    }
}
