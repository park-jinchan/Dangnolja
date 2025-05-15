package com.example.dangdang.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;

import com.example.dangdang.R;
import com.example.dangdang.adapter.ReservationAdapter;
import com.example.dangdang.adapter.ReviewAdapter;
import com.example.dangdang.model.Reservation;
import com.example.dangdang.model.Review;

import java.util.ArrayList;
import java.util.List;
public class ProviderMainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_provider_main);

        RecyclerView rvRes = findViewById(R.id.rvReservations);
        rvRes.setLayoutManager(new LinearLayoutManager(this));
        rvRes.setAdapter(new ReservationAdapter(getDummyReservations()));

        DividerItemDecoration decoRes = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvRes.addItemDecoration(decoRes);

        RecyclerView rvRev = findViewById(R.id.rvReviews);
        rvRev.setLayoutManager(new LinearLayoutManager(this));
        rvRev.setAdapter(new ReviewAdapter(getDummyReviews()));

        DividerItemDecoration decoRev = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvRev.addItemDecoration(decoRev);
    }

    private List<Reservation> getDummyReservations(){
        List<Reservation> list = new ArrayList<>();
        list.add(new Reservation("홍길동","2025-05-10","14:00",2));
        // …추가…
        return list;
    }
    private List<Review> getDummyReviews(){
        List<Review> list = new ArrayList<>();
        list.add(new Review("김철수",4.5f,"강아지도 편안해했어요."));
        // …추가…
        return list;
    }
}
