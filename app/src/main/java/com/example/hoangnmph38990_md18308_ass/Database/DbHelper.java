package com.example.hoangnmph38990_md18308_ass.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static  final String DB_NAME = "Lib_Manager";
    private static final int VERSION = 1;

    static final String CREATE_TABLE_THU_THU = "CREATE TABLE ThuThu (" +
            "    maTT    TEXT PRIMARY KEY," +
            "    hoTen   TEXT NOT NULL," +
            "    matKhau TEXT NOT NULL)";
    static final String sql_thuthu = "INSERT INTO ThuThu VALUES('1','hoang','1234')";
    //
    static final String CREATE_TABLE_THANH_VIEN = "CREATE TABLE ThanhVien (" +
            "    maTV    INTEGER PRIMARY KEY," +
            "    hoTen   TEXT NOT NULL," +
            "    namSinh TEXT NOT NULL)";
    //
    static final String CREATE_TABLE_LOAI_SACH = "CREATE TABLE LoaiSach (" +
            "    maLoai  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    tenLoai TEXT    NOT NULL)";
    //
    static final String CREATE_TABLE_SACH = "CREATE TABLE Sach (" +
            "    maSach  INTEGER  PRIMARY KEY AUTOINCREMENT," +
            "    tenSach TEXT     NOT NULL," +
            "    giaThue INTERGER NOT NULL," +
            "    maLoai  INTEGER  REFERENCES LoaiSach (maLoai) )";
    //
    static final String CREATE_TABLE_PHIEU_MUON = "CREATE TABLE PhieuMuon (" +
            "    maPM     INTEGER  PRIMARY KEY AUTOINCREMENT," +
            "    maTT     TEXT     REFERENCES ThuThu (maTT)," +
            "    maTV     TEXT     REFERENCES ThanhVien (maTV)," +
            "    maSach   INTEGER  REFERENCES Sach (maSach)," +
            "    tienThue INTEGER  NOT NULL," +
            "    ngay     DATE     NOT NULL," +
            "    traSach  INTERGER NOT NULL)";
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tao database o day
        db.execSQL(CREATE_TABLE_THU_THU);
        db.execSQL(sql_thuthu);

        db.execSQL(CREATE_TABLE_THANH_VIEN);

        db.execSQL(CREATE_TABLE_LOAI_SACH);

        db.execSQL(CREATE_TABLE_SACH);

        db.execSQL(CREATE_TABLE_PHIEU_MUON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTableThuThu = "drop table if exists ThuThu";
        db.execSQL(dropTableThuThu);
        String dropTableThanhVien = "drop table if exists ThanhVien";
        db.execSQL(dropTableThanhVien);
        String dropTableLoaiSach = "drop table if exists LoaiSach";
        db.execSQL(dropTableLoaiSach);
        String dropTableSach = "drop table if exists Sach";
        db.execSQL(dropTableSach);
        String dropTablePhieuMuon = "drop table if exists PhieuMuon";
        db.execSQL(dropTablePhieuMuon);

        onCreate(db);
    }
}
