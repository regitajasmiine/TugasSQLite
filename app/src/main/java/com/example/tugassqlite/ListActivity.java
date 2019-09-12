package com.example.tugassqlite;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListActivity extends AppCompatActivity implements RecyclerViewAdapter.OnUserClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Siswa> siswaList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        setupRecyclerView();
    }

    private void setupRecyclerView(){
        DatabaseHelper db = new DatabaseHelper(ListActivity.this);
        siswaList = db.selectUserData();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(ListActivity.this , siswaList,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

    }

    @Override
    public void onUserClick(Siswa currentPerson, String action) {
        if (action == "Delete"){
            DatabaseHelper db = new DatabaseHelper(ListActivity.this);
            db.delete(currentPerson.getNomor());
            setupRecyclerView();
        } else if(action == "Lihat"){
            DatabaseHelper db = new DatabaseHelper(ListActivity.this);
            Intent intent = new Intent(ListActivity.this, DetailDataActivity.class);
            intent.putExtra("Nomor",currentPerson.getNomor());
            intent.putExtra("Name",currentPerson.getName());
            intent.putExtra("Tanggal Lahir",currentPerson.getTgl_lahir());
            intent.putExtra("Jenkel",currentPerson.getJenkel());
            intent.putExtra("Alamat",currentPerson.getAlamat());
            startActivity(intent);
        }

    }
}
