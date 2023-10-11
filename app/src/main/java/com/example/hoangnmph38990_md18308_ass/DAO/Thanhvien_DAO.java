package com.example.hoangnmph38990_md18308_ass.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoangnmph38990_md18308_ass.Database.DbHelper;
import com.example.hoangnmph38990_md18308_ass.Model.Phieumuon;
import com.example.hoangnmph38990_md18308_ass.Model.Thanhvien;

import java.util.ArrayList;
import java.util.List;

public class Thanhvien_DAO {

    private SQLiteDatabase db;
    private DbHelper dbHelper;

    public Thanhvien_DAO(Context context){
        dbHelper = new DbHelper(context);
    }


    public int AddRow (Thanhvien obj){
        ContentValues values = new ContentValues();
        db = dbHelper.getWritableDatabase();

        values.put("maTV",obj.getMaTV());
        values.put("hoTen",obj.getHoTen());
        values.put("namSinh",obj.getNamSinh());

        return (int) db.insert("ThanhVien",null,values);
    }

    public int UpdateRow (Thanhvien obj){
        ContentValues values = new ContentValues();
        db = dbHelper.getWritableDatabase();

        values.put("maTV",obj.getMaTV()+"");
        values.put("hoTen",obj.getHoTen());
        values.put("namSinh",obj.getNamSinh());

        String[] dieukien =new String[]{ String.valueOf(obj.getMaTV()) };
        return (int) db.update("ThanhVien",values,"maTV = ?",dieukien);
    }

    public int DeleteRow (Thanhvien obj){

        String[] dieukien =new String[]{ String.valueOf(obj.getMaTV()) };
        return (int) db.delete("Thanhvien","maTV = ?",dieukien);
    }

    public List<Thanhvien> getAll(){
        ArrayList<Thanhvien> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM ThanhVien",null);
        if (c.getCount()>0){
            c.moveToFirst();
            while (!c.isAfterLast()){
                int  maTV = c.getInt(0);
                String hoTen = c.getString(1);
                String namSinh = c.getString(2);

                Thanhvien obj_tv = new Thanhvien(maTV,hoTen,namSinh);
                list.add(obj_tv);
                c.moveToNext();
            }
        }
        return list;
    }

}
