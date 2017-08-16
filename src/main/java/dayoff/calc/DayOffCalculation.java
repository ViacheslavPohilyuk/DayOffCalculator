package dayoff.calc;

import dayoff.calc.data.repo.DateRepository;
import dayoff.calc.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mac on 07.08.17.
 */
@Component
public class DayOffCalculation {

    @Autowired
    DateRepository dateRepository;

    public long computeHolidays(LocalDate startDate, LocalDate endDate) {
        long daysOffCount = 0;

        Comparator<Holiday> holidayComparator = (md1, md2) -> {
            int res = md1.getMonth() - md2.getMonth();
            if (res == 0)
                return md1.getDay() - md2.getDay();
            return res;
        };

        List<Holiday> holidays = dateRepository.getAll();

        holidays.sort(holidayComparator);

        DayOfWeek dayOfWeek;
        Holiday dayMonthOfPeriod;
        while (!startDate.isEqual(endDate)) {
            dayOfWeek = startDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                daysOffCount++;
            } else {
                dayMonthOfPeriod = new Holiday(startDate.getMonth().getValue(), startDate.getDayOfMonth());
                // dayMonthOfPeriod = MonthDay.of(startDate.getMonth(), startDate.getDayOfMonth());
                if (Collections.binarySearch(holidays, dayMonthOfPeriod, holidayComparator) >= 0)
                    daysOffCount++;
            }
            startDate = startDate.plus(Period.ofDays(1));
        }

        return daysOffCount;
    }
}
