package com.example.tugassqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "UserInfo";
    private static final String TABLE_NAME = "tbl_user";
    private static final String KEY_NOMOR = "nomor";
    private static final String KEY_NAME = "name";
    private static final String KEY_TGL = "tgl_lahir";
    private static final String KEY_JK = "jenkel";
    private static final String KEY_ALAMAT = "alamat";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserTable = "Create Table " + TABLE_NAME + "(" + KEY_NOMOR + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" + "," + KEY_TGL + " TEXT" + "," + KEY_JK + " TEXT," + KEY_ALAMAT+" TEXT)";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("drop table if exists " + TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Siswa siswa) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOMOR, siswa.getNomor());
        values.put(KEY_NAME, siswa.getName());
        values.put(KEY_TGL, siswa.getTgl_lahir());
        values.put(KEY_JK, siswa.getJenkel());
        values.put(KEY_ALAMAT, siswa.getAlamat());
        db.insert(TABLE_NAME, null, values);
    }

    public List<Siswa> selectUserData() {
        ArrayList<Siswa> userList = new ArrayList<Siswa>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {KEY_NOMOR, KEY_NAME, KEY_TGL, KEY_JK, KEY_ALAMAT};
        Cursor c = db.query(TABLE_NAME, columns, null, null, null, null, null);
        while (c.moveToNext()) {
            String name = c.getString(1);
            String nomor = c.getString(0);
            String tgl_lahir = c.getString(2);
            String jenkel = c.getString(3);
            String alamat = c.getString(4);

            Siswa siswa = new Siswa();
            siswa.setNomor(nomor);
            siswa.setName(name);
            siswa.setTgl_lahir(tgl_lahir);
            siswa.setJenkel(jenkel);
            siswa.setAlamat(alamat);
            userList.add(siswa);
        }
        return userList;
    }

    public void delete(String nomor) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = KEY_NOMOR + "='" + nomor + "'";
        db.delete(TABLE_NAME, whereClause, null);
    }

    public void update(Siswa siswa) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, siswa.getName());
        values.put(KEY_TGL, siswa.getTgl_lahir());
        values.put(KEY_JK, siswa.getJenkel());
        values.put(KEY_ALAMAT, siswa.getAlamat());
        String whereClause = KEY_NOMOR + "='" + siswa.getNomor() + "'";
        db.update(TABLE_NAME, values, whereClause, null);
    }
}
