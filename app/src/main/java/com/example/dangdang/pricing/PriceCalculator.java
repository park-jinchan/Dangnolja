package com.example.dangdang.pricing;

import java.util.Arrays;
import java.util.List;

/**
 * 호텔별 요금 규칙을 관리하고, 입력값에 따라 최종 요금을 반환합니다.
 */
public class PriceCalculator {
    /**
     * 호텔명, 반려견 체중, 주말 여부, 중성화 여부를 받아 최종 요금을 계산합니다.
     */
    public static int computePrice(
            String hotelName,
            double dogWeight,
            boolean isWeekend,
            boolean isNeutered
    ) {
        List<PriceRule> rules = rulesFor(hotelName);
        if (rules == null) {
            throw new IllegalArgumentException("Unknown hotel: " + hotelName);
        }
        // 해당 체중대의 요금 찾기
        for (PriceRule r : rules) {
            if (dogWeight <= r.maxWeight) {
                int base = isWeekend ? r.weekendPrice : r.weekdayPrice;
                // 중성화 안 했다면 +5,000원
                if (!isNeutered) {
                    base += 5000;
                }
                return base;
            }
        }
        // 만약 체중이 모두 초과한다면 마지막 규칙을 적용
        PriceRule last = rules.get(rules.size() - 1);
        int base = isWeekend ? last.weekendPrice : last.weekdayPrice;
        if (!isNeutered) base += 5000;
        return base;
    }

    /** 호텔별 PriceRule 목록을 반환합니다. */
    private static List<PriceRule> rulesFor(String hotelName) {
        switch (hotelName) {
            case "호텔 A":
                return Arrays.asList(
                        new PriceRule(5, 20000),
                        new PriceRule(8, 50000),
                        new PriceRule(Double.MAX_VALUE, 55000)
                );
            case "호텔 B":
                return Arrays.asList(
                        new PriceRule(6, 30000),
                        new PriceRule(9, 35000),
                        new PriceRule(Double.MAX_VALUE, 40000)
                );
            case "호텔 C":
                return Arrays.asList(
                        new PriceRule(5, 30000),
                        new PriceRule(10, 35000),
                        new PriceRule(15, 40000),
                        new PriceRule(Double.MAX_VALUE, 45000)
                );
            case "호텔 D":
                return Arrays.asList(
                        // 평일·주말 요금이 다름 → 두 번째 생성자 사용
                        new PriceRule(4, 30000, 35000),
                        new PriceRule(8, 35000, 38000),
                        new PriceRule(12, 40000, 45000),
                        new PriceRule(Double.MAX_VALUE, 45000, 50000) // 12kg 초과
                );
            case "호텔 E":
                return Arrays.asList(
                        new PriceRule(3, 30000, 35000),
                        new PriceRule(6, 35000, 40000),
                        new PriceRule(9, 40000, 45000),
                        new PriceRule(12, 45000, 50000),
                        new PriceRule(Double.MAX_VALUE, 50000, 55000)
                );
            default:
                return null;
        }
    }
}
