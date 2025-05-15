package com.example.dangdang.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dangdang.R;
import com.example.dangdang.model.Review;

import java.util.List;

// ReviewAdapter.java
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.VH> {
    private List<Review> list;
    public ReviewAdapter(List<Review> list) {
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Review r = list.get(position);
        holder.tvCust.setText(r.getCustomerName());
        holder.tvRating.setText(r.getRating() + "점");
        holder.tvComment.setText(r.getComment());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView tvCust, tvRating, tvComment;

        VH(View v) {
            super(v);
            tvCust = v.findViewById(R.id.tvRevCust);
            tvRating = v.findViewById(R.id.tvRevRating);
            tvComment = v.findViewById(R.id.tvRevComment);
        }
    }
}