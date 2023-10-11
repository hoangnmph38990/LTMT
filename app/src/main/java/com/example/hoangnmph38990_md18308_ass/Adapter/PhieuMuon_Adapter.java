package com.example.hoangnmph38990_md18308_ass.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoangnmph38990_md18308_ass.R;

public class PhieuMuon_Adapter extends RecyclerView.Adapter<PhieuMuon_Adapter.viewholder> {

    @NonNull
    @Override
    public PhieuMuon_Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phieumuon,parent,false);

        viewholder viewholder = new viewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuMuon_Adapter.viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class viewholder extends RecyclerView.ViewHolder{
        TextView tv_maphieu, tv_thanhvien, tv_tensach, tv_tienthue,tv_ngaythue,tv_trasach;
        Button btn_delete_phieumuon;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv_maphieu = itemView.findViewById(R.id.tv_maphieu_phieumuon);
            tv_thanhvien = itemView.findViewById(R.id.tv_thanhvien_phieumuon);
            tv_tensach = itemView.findViewById(R.id.tv_tensach_phieumuon);
            tv_tienthue = itemView.findViewById(R.id.tv_tienthue_phieumuon);
            tv_ngaythue = itemView.findViewById(R.id.tv_ngaythue_phieumuon);
            tv_trasach = itemView.findViewById(R.id.tv_trasach_phieumuon);

            btn_delete_phieumuon = itemView.findViewById(R.id.btn_delete_phieumuon);

        }
    }
}
