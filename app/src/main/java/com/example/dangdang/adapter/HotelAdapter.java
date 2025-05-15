package com.example.dangdang.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dangdang.R;
import com.example.dangdang.model.Hotel;
import com.example.dangdang.pricing.PriceCalculator;

import java.util.List;
public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.VH> {
    private List<Hotel> list;
    private double dogWeight;
    private boolean isWeekend;
    private boolean isNeutered;

    public HotelAdapter(List<Hotel> list) {
        this(list, 0, false, true);
    }
    public HotelAdapter(List<Hotel> list,
                        double dogWeight,
                        boolean isWeekend,
                        boolean isNeutered){
        this.list = list;
        this.dogWeight = dogWeight;
        this.isWeekend = isWeekend;
        this.isNeutered = isNeutered;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hotel, parent, false);
        return new VH(itemView);
    }
    @Override
    public void onBindViewHolder(VH h, int pos) {
        Hotel m = list.get(pos);
        h.imgHotel.setImageResource(m.getImageResId());
        h.tvHotelName.setText(m.getName());

        h.tvRatingReview.setText(
                String.format("%.1f (%d reviews)", m.getRating(), m.getReviewCount())
        );
        h.tvVacancyDistance.setText(
                String.format("Vacancy: %d • %s", m.getVacancy(), m.getDistanceText())
        );
        int price = PriceCalculator.computePrice(
                m.getName(),
                dogWeight,
                isWeekend,
                isNeutered
        );
        h.tvPrice.setText(String.format("%,d원", price));
    }
    @Override public int getItemCount(){
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView imgHotel;
        TextView tvHotelName, tvRatingReview, tvVacancyDistance;
        TextView tvPrice;  // ← 이 줄 추가
        VH(View v){
            super(v);
            imgHotel = v.findViewById(R.id.imgHotel);
            tvHotelName = v.findViewById(R.id.tvHotelName);
            tvRatingReview = v.findViewById(R.id.tvRatingReview);
            tvVacancyDistance = v.findViewById(R.id.tvVacancyDistance);
            tvPrice = v.findViewById(R.id.tvPrice);
        }
    }
}
