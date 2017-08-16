package dayoff.calc;

import dayoff.calc.data.repo.DateRepository;
import dayoff.calc.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mac on 07.08.17.
 */
@Component
public class DayOffCalculation {

    @Autowired
    private DateRepository dateRepository;

    public long computeHolidays(LocalDate startDate, LocalDate endDate, boolean endDateIncluded) {
        long daysOffCount = 0;

        Comparator<Holiday> holidayComparator = (md1, md2) -> {
            int res = md1.getMonth() - md2.getMonth();
            if (res == 0)
                return md1.getDay() - md2.getDay();
            return res;
        };

        List<Holiday> holidays = dateRepository.getAll();

        System.out.println("holidays:");
        for (Holiday h : holidays)
            System.out.println(h.toString());

        holidays.sort(holidayComparator);

        DayOfWeek dayOfWeek;
        Holiday dayMonthOfPeriod;
        while (!startDate.isEqual(endDate)) {
            dayOfWeek = startDate.getDayOfWeek();
            System.out.print(startDate.toString() + " " + dayOfWeek.toString());
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                daysOffCount++;
                System.out.println(" weekend");
            } else {
                dayMonthOfPeriod = new Holiday(startDate.getMonth().getValue(), startDate.getDayOfMonth());
                if (Collections.binarySearch(holidays, dayMonthOfPeriod, holidayComparator) >= 0) {
                    daysOffCount++;
                    System.out.println("holiday");
                }
            }
            startDate = startDate.plus(Period.ofDays(1));
        }

        return daysOffCount;
    }
}
