package com.example.congestiontaxcalculator.model.tollfee;

import com.example.congestiontaxcalculator.model.City;
import com.example.congestiontaxcalculator.model.tollfee.impl.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Class that has mock toll fee data. It should have a proper DB representation, and interface for user to input these.
* Such controller could be implemented in TollFeeRangeController.java file.*/
@Service
public class TollFeeRangeServiceMockImpl implements TollFeeRangeService {

    //In real world an alternative to priority queue would be SQL queries returning first result sorted by priority
    private static final PriorityQueue<TollFeeRange> TOLL_FEE_TIME_RANGES =
            new PriorityQueue<>(Comparator.comparing(TollFeeRange::getPriority));

    private static final LocalDateTime START_OF_2013 = LocalDateTime.of(2013, Month.JANUARY, 1, 0, 0);
    private static final LocalDateTime END_OF_2013 = START_OF_2013.plus(1, ChronoUnit.YEARS);
    private static final LocalDateTime MARCH_2023_03_28 = LocalDateTime.of(2013, Month.MARCH, 28, 0, 0);
    private static final LocalDateTime APRIL_2023_04_01 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_04_30 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_05_01 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_05_08 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_06_05 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_06_21 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_11_01 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_12_24 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);
    private static final LocalDateTime APRIL_2023_12_31 = LocalDateTime.of(2013, Month.APRIL, 1, 0, 0);

    static {
        TOLL_FEE_TIME_RANGES.add(new DayOfWeekTollFeeRange(DayOfWeek.SATURDAY, START_OF_2013, END_OF_2013, 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DayOfWeekTollFeeRange(DayOfWeek.SUNDAY, START_OF_2013, END_OF_2013, 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new MonthTollFeeRange(Month.JANUARY, 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(MARCH_2023_03_28, MARCH_2023_03_28.plus(2, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_04_01, APRIL_2023_04_01.plus(1, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_04_30, APRIL_2023_04_30.plus(1, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_05_01, APRIL_2023_05_01.plus(1, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_05_08, APRIL_2023_05_08.plus(2, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_06_05, APRIL_2023_06_05.plus(2, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_06_21, APRIL_2023_06_21.plus(1, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new MonthTollFeeRange(Month.JULY, 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_11_01, APRIL_2023_11_01.plus(1, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_12_24, APRIL_2023_12_24.plus(3, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new DateTimeTollFeeRange(APRIL_2023_12_31, APRIL_2023_12_31.plus(1, ChronoUnit.DAYS), 0, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(6, 0, 6, 30, 8, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(6, 30, 7, 0, 13, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(7, 0, 8, 0, 13, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(8, 0, 8, 30, 13, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new MinuteFixedTollFeeRange(8, 0, 14, 30, 8, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(15, 0, 15, 30, 13, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(15, 0, 17, 0, 13, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(17, 0, 18, 0, 13, City.GOTHENBURG));
        TOLL_FEE_TIME_RANGES.add(new TimeRangeTollFeeRange(18, 0, 18, 30, 8, City.GOTHENBURG));
    }

    @Override
    public BigDecimal getTollFee(LocalDateTime date, City city) {
        for (TollFeeRange tollFeeRangeTimeRange : TOLL_FEE_TIME_RANGES) {
            if (tollFeeRangeTimeRange.isInTimeRange(date) && tollFeeRangeTimeRange.getCity() == city) {
                return tollFeeRangeTimeRange.getTollFee();
            }
        }

        return BigDecimal.ZERO;
    }
}
