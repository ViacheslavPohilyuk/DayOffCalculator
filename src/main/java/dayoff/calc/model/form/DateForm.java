package dayoff.calc.model.form;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by mac on 08.08.17.
 */
/* Lombok annotations
 * for generating getters, setters, toString and constructors */
@Data
@NoArgsConstructor
@AllArgsConstructor
/*------------------------------------------------------------*/
public class DateForm {

    @Pattern(regexp = "^[0-9]{2}", message = "{start_date.day.pattern}")
    @Range(min = 1, max = 31, message = "{start_date.day.range}")
    private String startDateDay;

    @Pattern(regexp = "^[0-9]{2}", message = "{start_date.month.pattern}")
    @Range(min = 1, max = 12, message = "{start_date.month.range}")
    private String startDateMonth;

    @Pattern(regexp = "^[0-9]{4}", message = "{start_date.year.pattern}")
    @Range(min = 1, max = 9999, message = "{start_date.year.range}")
    private String startDateYear;

    @Pattern(regexp = "^[0-9]{2}", message = "{end_date.day.pattern}")
    @Range(min = 1, max = 31, message = "{end_date.day.range}")
    private String endDateDay;

    @Pattern(regexp = "^[0-9]{2}", message = "{end_date.month.pattern}")
    @Range(min = 1, max = 12, message = "{end_date.month.range}")
    private String endDateMonth;

    @Pattern(regexp = "^[0-9]{4}", message = "{end_date.year.pattern}")
    @Range(min = 1, max = 9999, message = "{end_date.year.range}")
    private String endDateYear;

    private boolean endDayIncluded = false;

    public int startDateDay() {
        return Integer.parseInt(startDateDay);
    }

    public int startDateMonth() {
        return Integer.parseInt(startDateMonth);
    }

    public int startDateYear() {
        return Integer.parseInt(startDateYear);
    }

    public int endDateDay() {
        return Integer.parseInt(endDateDay);
    }

    public int endDateMonth() {
        return Integer.parseInt(endDateMonth);
    }

    public int endDateYear() {
        return Integer.parseInt(endDateYear);
    }
}
