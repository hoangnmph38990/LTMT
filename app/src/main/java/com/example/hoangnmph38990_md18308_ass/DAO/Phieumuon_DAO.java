package com.example.hoangnmph38990_md18308_ass.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoangnmph38990_md18308_ass.Database.DbHelper;
import com.example.hoangnmph38990_md18308_ass.Model.Phieumuon;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Phieumuon_DAO {
    private SQLiteDatabase db;
    private DbHelper dbHelper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Phieumuon_DAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public int AddRow(Phieumuon obj){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("maPM",obj.getMaPM()+"");
        values.put("maTT",obj.getMaTT());
        values.put("maTV",obj.getMaTV());
        values.put("maSach",obj.getMaSach()+"");
        values.put("tienThue",obj.getTienThue()+"");
        values.put("ngay",sdf.format(obj.getNgay()));
        values.put("traSach",obj.getTraSach()+"");

        return (int) db.insert("PhieuMuon",null,values);
    }

    public int UpdateRow(Phieumuon obj){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("maPM",obj.getMaPM()+"");
        values.put("maTT",obj.getMaTT());
        values.put("maTV",obj.getMaTV());
        values.put("maSach",obj.getMaSach()+"");
        values.put("tienThue",obj.getTienThue()+"");
        values.put("ngay",sdf.format(obj.getNgay()));
        values.put("traSach",obj.getTraSach()+"");

        String[] dieukien = new String[]{String.valueOf(obj.getMaPM())};
        return (int) db.update("PhieuMuon",values,"maPM = ?",dieukien);
    }

    public int DeleteRow(Phieumuon obj){

        String[] dieukien = new String[]{String.valueOf(obj.getMaPM())};
        return (int) db.delete("PhieuMuon","maPM = ?",dieukien);
    }

    public List<Phieumuon> getALl(){
        ArrayList<Phieumuon> list = new ArrayList<>();
        db = dbHelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Sach",null);
        if (c.getCount() > 0){
            c.moveToFirst();
            while (!c.isAfterLast()){

                int maPM = c.getInt(0);
                String maTT = c.getString(1);
                String maTV = c.getString(2);
                int maSach = c.getInt(3);
                int tienThue = c.getInt(4);
                String ngay = c.getString(5);
                int traSach = c.getInt(6);

                Phieumuon obj_pm = new Phieumuon(maPM,maTT,maTV,maSach,tienThue,ngay,traSach);
                list.add(obj_pm);
                c.moveToNext();
            }
        }

        return list;
    }
}
