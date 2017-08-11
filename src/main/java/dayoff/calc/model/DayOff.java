package dayoff.calc.model;

import lombok.Data;

/**
 * Created by mac on 06.08.17.
 */
@Data
public class DayOff {
    int day;

    int month;

    public DayOff(int day, int month) {
        this.day = day;
        this.month = month;
    }
}
