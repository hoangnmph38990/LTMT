package com.example.hoangnmph38990_md18308_ass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoangnmph38990_md18308_ass.DAO.Thuthu_DAO;
import com.example.hoangnmph38990_md18308_ass.Model.Thuthu;

public class Dang_nhap extends AppCompatActivity {

    EditText ed_username_dn;
    EditText ed_password_dn;

    Button btn_login_dn;
    Button btn_cancel_dn;
    CheckBox chk_nhomatkhau;

    Thuthu_DAO thuthu_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        //anh xa
        ed_username_dn = findViewById(R.id.ed_username_dn);
        ed_password_dn = findViewById(R.id.ed_password_dn);

        btn_login_dn = findViewById(R.id.btn_login_dn);
        btn_cancel_dn = findViewById(R.id.btn_cancel_dn);
        chk_nhomatkhau = findViewById(R.id.chk_nhomatkhau_dn);

        thuthu_dao = new Thuthu_DAO(this);

        btn_login_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = ed_username_dn.getText().toString();
                String pass = ed_password_dn.getText().toString();

                boolean check = thuthu_dao.Check_login(user,pass);

                if (user.equals("") || pass.equals("")){
                    Toast.makeText(Dang_nhap.this, "Vui Lòng Nhập Đầy Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (check){
                    Toast.makeText(Dang_nhap.this, "Chào Mừng Bạn Đến Với Thư Vện PNLIB", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Dang_nhap.this,Man_hinh_chinh.class));
                }
            }
        });

    }
}