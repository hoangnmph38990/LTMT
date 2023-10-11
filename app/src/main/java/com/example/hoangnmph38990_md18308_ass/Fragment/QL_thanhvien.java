package com.example.hoangnmph38990_md18308_ass.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoangnmph38990_md18308_ass.Adapter.Thanhvien_Adapter;
import com.example.hoangnmph38990_md18308_ass.DAO.Thanhvien_DAO;
import com.example.hoangnmph38990_md18308_ass.Model.Thanhvien;
import com.example.hoangnmph38990_md18308_ass.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class QL_thanhvien extends Fragment {

    FloatingActionButton btn_add_tv;
    RecyclerView rcv_thanhvien;
    Thanhvien_Adapter adapter;
    Thanhvien_DAO thanhvien_dao;
    List<Thanhvien> list_tv;
    public QL_thanhvien() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_q_l_thanhvien, container, false);

        //anh xa
        btn_add_tv = v.findViewById(R.id.btn_thanhvien_add);
        rcv_thanhvien = v.findViewById(R.id.rcv_thanhvien);

        thanhvien_dao = new Thanhvien_DAO(getContext());
        list_tv = thanhvien_dao.getAll();
        adapter = new Thanhvien_Adapter(getContext(),list_tv);
        rcv_thanhvien.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcv_thanhvien.setLayoutManager(linearLayoutManager);

        btn_add_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogAdd();
            }
        });
        return v;
    }
    void dialogAdd(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.item_thanhvien_dialog,null);
        builder.setView(v);

        builder.setCancelable(false);
        AlertDialog dialog = builder.create(); // khoi tao dia log

        EditText ed_hoten = v.findViewById(R.id.ed_hoten_tv);
        EditText ed_namsinh = v.findViewById(R.id.ed_namsinh_tv);

        Button btn_save = v.findViewById(R.id.btn_save_tv);
        Button btn_cancel = v.findViewById(R.id.btn_cancel_tv);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hoten = ed_hoten.getText().toString();
                String namsinh = ed_namsinh.getText().toString();

                Thanhvien_DAO dao = new Thanhvien_DAO(getContext());
                Thanhvien tv = new Thanhvien(hoten,namsinh);

                int kq = dao.AddRow(tv);

                if(hoten.equals("") || namsinh.equals("")){
                    Toast.makeText(getContext(), "Vui Long Nhap Day Du", Toast.LENGTH_SHORT).show();
                } else if(kq > 0 ){
                    list_tv.clear();
                    list_tv.addAll(dao.getAll());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Them Thanh COng ", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }



            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}