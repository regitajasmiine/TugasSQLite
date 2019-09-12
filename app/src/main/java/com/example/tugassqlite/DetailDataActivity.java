package com.example.tugassqlite;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailDataActivity extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4,txt5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildata);

        txt1 = (EditText)findViewById(R.id.Edit1);
        txt2 =(EditText)findViewById(R.id.Edit2);
        txt3 =(EditText)findViewById(R.id.Edit3);
        txt4 =(EditText)findViewById(R.id.Edit4);
        txt5 =(EditText)findViewById(R.id.Edit5);

        txt1.setText(getIntent().getStringExtra("Nomor"));
        txt2.setText(getIntent().getStringExtra("Name"));
        txt3.setText(getIntent().getStringExtra("Tanggal Lahir"));
        txt4.setText(getIntent().getStringExtra("Jenkel"));
        txt5.setText(getIntent().getStringExtra("Alamat"));




    }
}
