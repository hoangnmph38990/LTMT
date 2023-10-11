package com.example.hoangnmph38990_md18308_ass.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoangnmph38990_md18308_ass.Database.DbHelper;
import com.example.hoangnmph38990_md18308_ass.Model.Thuthu;

public class Thuthu_DAO {
    private SQLiteDatabase db;
    private DbHelper dbHelper;

    public Thuthu_DAO(Context context){
         dbHelper = new DbHelper(context);
    }

    public boolean Check_login(String hoTen, String matKhau){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put("hoTen",hoTen);
        values.put("matKhau",matKhau);

        Cursor c = db.rawQuery("SELECT * FROM ThuThu WHERE hoTen = ? AND matKhau = ?",new String[]{hoTen,matKhau});
        return c.getCount()>0;
    }
}
