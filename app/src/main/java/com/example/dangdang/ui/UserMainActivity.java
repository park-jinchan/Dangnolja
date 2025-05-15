package com.example.dangdang.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.location.Location;
import android.os.Bundle;

import com.example.dangdang.R;
import com.example.dangdang.adapter.HotelAdapter;
import com.example.dangdang.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class UserMainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_user_main);

        RecyclerView rv = findViewById(R.id.rvHotels);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // (1) 현재 위치 시뮬레이션
        Location curr = new Location("");
        curr.setLatitude(37.5665);
        curr.setLongitude(126.9780);

        // (2) 더미 데이터 + 5km 필터
        List<Hotel> all = getDummyHotels();
        List<Hotel> nearby = new ArrayList<>();
        for(Hotel h: all){
            float[] dist = new float[1];
            Location.distanceBetween(
                    curr.getLatitude(), curr.getLongitude(),
                    h.getLatitude(), h.getLongitude(), dist
            );
            if(dist[0] <= 5000){
                h.setDistanceText(String.format("%.1f km", dist[0]/1000));
                nearby.add(h);
            }
        }
// (3) 사용자 입력 · 계산값 세팅
        double myWeight   = 7.3;                    // 예시: 7.3kg
        boolean weekend   = isTodayWeekend();       // 오늘이 주말인지 체크
        boolean neutered  = false;                  // 중성화 여부 (사용자 입력)

        // (4) 새 생성자를 이용해 가격까지 함께 표시
        rv.setAdapter(new HotelAdapter(nearby, myWeight, weekend, neutered));
    }

    // helper: 오늘이 주말인지 판단하는 메서드
    private boolean isTodayWeekend() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        return day == Calendar.SATURDAY || day == Calendar.SUNDAY;
    }

    private List<Hotel> getDummyHotels(){
        List<Hotel> list = new ArrayList<>();
        list.add(new Hotel("호텔 A", R.drawable.hotel_a,4.5f,120,2,37.5700,126.9860));
        list.add(new Hotel("호텔 B", R.drawable.hotel_b, 4.2f,  98,  3, 37.5650, 126.9820));
        list.add(new Hotel("호텔 C", R.drawable.hotel_c, 4.8f, 200,  1, 37.5680, 126.9750));
        list.add(new Hotel("호텔 D", R.drawable.hotel_d, 3.9f,  45,  5, 37.5630, 126.9900));
        list.add(new Hotel("호텔 E", R.drawable.hotel_e, 4.0f,  70,  4, 37.5690, 126.9800));
        // …총 5~6개 추가…
        return list;
    }
}

