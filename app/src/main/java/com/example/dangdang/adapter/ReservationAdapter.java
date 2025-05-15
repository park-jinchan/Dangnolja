package com.example.dangdang.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dangdang.R;
import com.example.dangdang.model.Reservation;

import java.util.List;

// ReservationAdapter.java
public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.VH> {
    private List<Reservation> list;
    public ReservationAdapter(List<Reservation> list) {
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reservation, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Reservation r = list.get(position);
        holder.tvCust.setText(r.getCustomerName());
        holder.tvDateTime.setText(r.getDate() + " " + r.getTime());
        holder.tvParty.setText("인원: " + r.getPartySize());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView tvCust, tvDateTime, tvParty;

        VH(View v) {
            super(v);
            tvCust = v.findViewById(R.id.tvResCust);
            tvDateTime = v.findViewById(R.id.tvResDateTime);
            tvParty = v.findViewById(R.id.tvResParty);
        }
    }
}