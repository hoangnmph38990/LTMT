package com.example.hoangnmph38990_md18308_ass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoangnmph38990_md18308_ass.DAO.Thanhvien_DAO;
import com.example.hoangnmph38990_md18308_ass.Model.Thanhvien;
import com.example.hoangnmph38990_md18308_ass.R;

import java.util.List;

public class Thanhvien_Adapter extends RecyclerView.Adapter<Thanhvien_Adapter.viewholder> {

    Context context;

    public Thanhvien_Adapter(Context context, List<Thanhvien> list_tv) {
        this.context = context;
        this.list_tv = list_tv;
    }

    List<Thanhvien> list_tv;

    @NonNull
    @Override
    public Thanhvien_Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thanhvien,parent,false);

        viewholder holder = new viewholder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Thanhvien_Adapter.viewholder holder, int position) {

        Thanhvien obj_tv = list_tv.get(position);

        holder.tv_mathanhvien.setText(obj_tv.getMaTV()+"");
        holder.tv_tenthanhvien.setText(obj_tv.getHoTen());
        holder.tv_namsinh.setText(obj_tv.getNamSinh());

    }

    @Override
    public int getItemCount() {
        return list_tv.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView tv_mathanhvien, tv_tenthanhvien, tv_namsinh;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            tv_mathanhvien = itemView.findViewById(R.id.tv_mathanhvien_tv);
            tv_tenthanhvien = itemView.findViewById(R.id.tv_tenthanhvien_tv);
            tv_namsinh = itemView.findViewById(R.id.tv_namsinh_tv);

        }
    }
}
