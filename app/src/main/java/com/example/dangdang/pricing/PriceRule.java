package com.example.dangdang.pricing;

/**
 * 체중 최대치(maxWeight) 이하일 때 적용할 요금(weekdayPrice)
 * 와 주말 요금(weekendPrice)을 담는 클래스입니다.
 */
public class PriceRule {
    public final double maxWeight;      // kg
    public final int weekdayPrice;      // 원
    public final int weekendPrice;      // 원

    // 기본 생성자: 주말 요금이 평일 + 5,000원인 경우
    public PriceRule(double maxWeight, int price) {
        this(maxWeight, price, price + 5000);
    }

    // 평일/주말 요금을 모두 명시하는 경우
    public PriceRule(double maxWeight, int weekdayPrice, int weekendPrice) {
        this.maxWeight = maxWeight;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
    }
}
