package com.example.tugassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    EditText text1, text2, text3, text4, text5;
    String Etext1, Etext2, Etext3, Etext4, Etext5;
    Button btnSave;
    DatabaseHelper databaseHelper;
    Siswa siswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);



        text1 = (EditText) findViewById(R.id.Edit1);
        text2 = (EditText) findViewById(R.id.Edit2);
        text3 = (EditText) findViewById(R.id.Edit3);
        text4 = (EditText) findViewById(R.id.Edit4);
        text5 = (EditText) findViewById(R.id.Edit5);
        btnSave   = (Button) findViewById(R.id.Update);
        text1.setText(getIntent().getStringExtra("Nomor"));
        text2.setText(getIntent().getStringExtra("Name"));
        text3.setText(getIntent().getStringExtra("Tanggal Lahir"));
        text4.setText(getIntent().getStringExtra("Jenkel"));
        text5.setText(getIntent().getStringExtra("Alamat"));
        databaseHelper = new DatabaseHelper(Update.this);
        siswa = new Siswa();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });

    }

    public void updateData() {
        siswa.setNomor(text1.getText().toString());
        siswa.setName(text2.getText().toString());
        siswa.setTgl_lahir(text3.getText().toString());
        siswa.setJenkel(text4.getText().toString());
        siswa.setAlamat(text5.getText().toString());
        databaseHelper.update(siswa);
        startActivity(new Intent(Update.this, ListActivity.class));
        finish();
    }
}
