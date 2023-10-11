package com.example.hoangnmph38990_md18308_ass.Model;

public class Loaisach {
    private int maloai;
    private String tenLoai;

    public Loaisach() {
    }

    public Loaisach(int maloai, String tenLoai) {
        this.maloai = maloai;
        this.tenLoai = tenLoai;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
