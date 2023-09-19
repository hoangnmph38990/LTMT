package com.example.hoangnmph38990_md18308_ass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hoangnmph38990_md18308_ass.Fragment.QL_loaisach;
import com.example.hoangnmph38990_md18308_ass.Fragment.QL_phieumuon;
import com.example.hoangnmph38990_md18308_ass.Fragment.QL_sach;
import com.example.hoangnmph38990_md18308_ass.Fragment.QL_thanhvien;
import com.example.hoangnmph38990_md18308_ass.Fragment_Nguoidung.ND_doimatkhau;
import com.example.hoangnmph38990_md18308_ass.Fragment_Nguoidung.ND_themnguoidung;
import com.example.hoangnmph38990_md18308_ass.Fragment_Thongke.TK_doanhthu;
import com.example.hoangnmph38990_md18308_ass.Fragment_Thongke.TK_topsach;
import com.google.android.material.navigation.NavigationView;

public class Man_hinh_chinh extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView nv_view;
    DrawerLayout drawer_layout;
    FragmentContainerView fragmentContainerView;

    //cac man hinh
    QL_loaisach ql_loaisach;
    QL_phieumuon ql_phieumuon;
    QL_sach ql_sach;
    QL_thanhvien ql_thanhvien;
    TK_topsach tk_topsach;
    TK_doanhthu tk_doanhthu;
    ND_themnguoidung nd_themnguoidung;
    ND_doimatkhau nd_doimatkhau;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        //Anh Xa

        toolbar = findViewById(R.id.toolbar);
        nv_view = findViewById(R.id.nv_view);
        drawer_layout = findViewById(R.id.drawer_layout);
        fragmentContainerView = findViewById(R.id.Fragment_container);

        // xu ly toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer_layout,
                toolbar,
                R.string.open,
                R.string.close);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawer_layout.addDrawerListener(toggle);

        //cac man hinh navigation menu
        ql_loaisach = new QL_loaisach();
        ql_phieumuon = new QL_phieumuon();
        ql_sach = new QL_sach();
        ql_thanhvien = new QL_thanhvien();

        tk_topsach = new TK_topsach();
        tk_doanhthu = new TK_doanhthu();

        nd_themnguoidung = new ND_themnguoidung();
        nd_doimatkhau = new ND_doimatkhau();

        //
        getSupportFragmentManager().beginTransaction().add(R.id.Fragment_container, ql_phieumuon);

        nv_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.Ql_phieumuon){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,ql_phieumuon)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Ql_loaisach) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,ql_loaisach)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Ql_sach) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,ql_sach)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Ql_thanhvien) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,ql_thanhvien)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Tk_topsach){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,tk_topsach)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Tk_doanhthu){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,tk_doanhthu)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Nd_add_nguoidung) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,nd_themnguoidung)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Nd_doimatkhau) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,nd_doimatkhau)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else if (item.getItemId() == R.id.Nd_exit) {
                    showComfimDialog();
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container,ql_phieumuon)
                            .commit();
                    getSupportActionBar().setTitle(item.getTitle());
                }

                drawer_layout.close();
                return true;
            }
        });
    }
    void showComfimDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Thoát Phần Mềm ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplication(), "Thoát Thành Công", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // không làm gì, tất dialog đi
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false);// bắt buộc người dùng phải bấm nút đồng ý  hoặc không thì mới tắt dialog
        AlertDialog dialog = builder.create(); // tạo dialog hoan chỉnh
        dialog.show(); // hiển thị.

    }
}