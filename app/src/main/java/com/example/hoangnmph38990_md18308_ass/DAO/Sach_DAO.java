package com.example.hoangnmph38990_md18308_ass.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoangnmph38990_md18308_ass.Database.DbHelper;
import com.example.hoangnmph38990_md18308_ass.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class Sach_DAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public Sach_DAO(Context context){
        dbHelper = new DbHelper(context);
    }


    public int AddRow(Sach obj){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("maSach",obj.getMaSach()+"");
        values.put("tenSach",obj.getTenSach());
        values.put("giaThue",obj.getGiaThue()+"");
        values.put("maLoai", obj.getMaloai()+"");

        return (int) db.insert("Sach",null,values);
    }

    public int UpdateRow(Sach obj){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("maSach",obj.getMaSach()+"");
        values.put("tenSach",obj.getTenSach());
        values.put("giaThue",obj.getGiaThue()+"");
        values.put("maLoai", obj.getMaloai()+"");

        String[] dieukien = new String[]{String.valueOf(obj.getMaloai())};
        return (int) db.update("Sach",values,"maSach = ?",dieukien);
    }

    public int DeleteRow(Sach obj){

        String[] dieukien = new String[]{String.valueOf(obj.getMaloai())};
        return (int) db.delete("Sach","maSach = ?",dieukien);
    }

    public List<Sach> getAll(){
        ArrayList<Sach> list = new ArrayList<>();
        db = dbHelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Sach",null);
        if (c.getCount() > 0){
            c.moveToFirst();
            while (!c.isAfterLast()){

                int maSach = c.getInt(0);
                String tenSach = c.getString(1);
                int giaThue = c.getInt(2);
                int maLoai = c.getInt(3);

                Sach obj_s = new Sach(maSach,tenSach,giaThue,maLoai);
                list.add(obj_s);
                c.moveToNext();
            }
        }
        return list;
    }
}
