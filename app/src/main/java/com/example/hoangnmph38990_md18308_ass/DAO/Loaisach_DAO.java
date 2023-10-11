package com.example.hoangnmph38990_md18308_ass.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoangnmph38990_md18308_ass.Database.DbHelper;
import com.example.hoangnmph38990_md18308_ass.Model.Loaisach;

import java.util.ArrayList;
import java.util.List;

public class Loaisach_DAO {
    DbHelper dbHelper;
    SQLiteDatabase db;

    public Loaisach_DAO(Context context){
    dbHelper = new DbHelper(context);
    }

    public int AddRow(Loaisach obj){
        ContentValues values = new ContentValues();
        db = dbHelper.getWritableDatabase();

        values.put("maLoai",obj.getMaloai()+"");
        values.put("tenLoai",obj.getTenLoai());

        return (int) db.insert("LoaiSach",null,values);

    }

    public int UpdateRow(Loaisach obj){
        ContentValues values = new ContentValues();
        db = dbHelper.getWritableDatabase();

        values.put("maLoai",obj.getMaloai()+"");
        values.put("tenLoai",obj.getTenLoai());

        String[] dieukien = new String[]{String.valueOf(obj.getMaloai())};
        return (int) db.update("LoaiSach",values,"maLoai = ?",dieukien);

    }

    public int DeleteRow(Loaisach obj){

        String[] dieukien = new String[]{String.valueOf(obj.getMaloai())};
        return (int) db.delete("LoaiSach","maLoai = ?",dieukien);
    }

    public List<Loaisach> getAll(){
        List<Loaisach> list = new ArrayList<>();
        SQLiteDatabase db =dbHelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM LoaiSach",null);
        if (c.getCount() > 0){
            c.moveToFirst();
            while (!c.isAfterLast()){
                int maLoai = c.getInt(0);
                String tenLoai = c.getString(1);

                Loaisach obj_ls = new Loaisach(maLoai,tenLoai);
                list.add(obj_ls);
                c.moveToNext();
            }
        }
    return list;
    }
}
