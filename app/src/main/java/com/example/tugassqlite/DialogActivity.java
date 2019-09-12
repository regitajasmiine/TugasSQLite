package com.example.tugassqlite;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity{
    EditText text1, text2, text3, text4, text5;
    String Etext1, Etext2, Etext3, Etext4, Etext5;
    Button btnSave;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        text1 = (EditText)findViewById(R.id.edit1);
        text2 = (EditText)findViewById(R.id.edit2);
        text3 = (EditText)findViewById(R.id.edit3);
        text4 = (EditText)findViewById(R.id.edit4);
        text5 = (EditText)findViewById(R.id.edit5);

        btnSave= (Button)findViewById(R.id.btnSimpan);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Etext1= text1.getText().toString();
                Etext2= text2.getText().toString();
                Etext3= text3.getText().toString();
                Etext4= text4.getText().toString();
                Etext5= text5.getText().toString();

                DatabaseHelper db = new DatabaseHelper(DialogActivity.this);
                Siswa currentPerson = new Siswa();
                currentPerson.setNomor(Etext1);
                currentPerson.setName(Etext2);
                currentPerson.setTgl_lahir(Etext3);
                currentPerson.setJenkel(Etext4);
                currentPerson.setAlamat(Etext5);

                db.insert(currentPerson);
            }
        });


    }
}
