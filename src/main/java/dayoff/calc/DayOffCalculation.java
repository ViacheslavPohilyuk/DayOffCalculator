package dayoff.calc;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by mac on 07.08.17.
 */
@Component
public class DayOffCalculation {

    public long computeWeekendsCount(LocalDate startDate, LocalDate endDate) {

        long daysOffCount = 0;
        long diffInDays = ChronoUnit.DAYS.between(startDate, endDate);
        int dayOfFirstWeeks = startDate.getDayOfWeek().getValue();

        /* Count the number of weekends in the first two weeks
           of a period between two dates */
        if (dayOfFirstWeeks != 1) {
            outer:
            for (int week = 0; week < 2; week++) {
                for (; dayOfFirstWeeks <= 7; dayOfFirstWeeks++, diffInDays--) {
                    if (diffInDays <= 0) {
                        break outer;
                    }
                    if (dayOfFirstWeeks >= 6) {
                        daysOffCount++;
                    }
                }
                dayOfFirstWeeks %= 7;
            }
        }

        /* Find a count of weekends by dividing diffInDays by 7
           and multiplying by 2 the result of dividing */
        daysOffCount += (diffInDays / 7) * 2;

        /* Find a count of weekends of last week of a period */
        daysOffCount += (diffInDays % 7 == 6) ? 1 : 0;

        return daysOffCount;
    }
}
