package dayoff.calc.model.form;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

/**
 * Created by mac on 08.08.17.
 */
@Data
@NoArgsConstructor
public class DateForm {

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 31, message = "{start_date.day.range}")
    private String startDateDay;

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 12, message = "start_date.day.range")
    private String startDateMonth;

    @Pattern(regexp = "^[0-9]{4}")
    @Range(min = 1, max = 9999)
    private String startDateYear;

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 31)
    private String endDateDay;

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 12)
    private String endDateMonth;

    @Pattern(regexp = "^[0-9]{4}")
    @Range(min = 1, max = 9999)
    private String endDateYear;

    public @Range(min = 1, max = 31, message = "{start_date.day.range}")
    int startDateDay() {
        return Integer.parseInt(startDateDay);
    }

    public @Range(min = 1, max = 12, message = "{start_date.day.range}")
    int startDateMonth() {
        return Integer.parseInt(startDateMonth);
    }

    public @Range(min = 1, max = 9999, message = "{start_date.day.range}")
    int startDateYear() {
        return Integer.parseInt(startDateYear);
    }

    public @Range(min = 1, max = 31, message = "{start_date.day.range}")
    int endDateDay() {
        return Integer.parseInt(endDateDay);
    }

    public @Range(min = 1, max = 12, message = "{start_date.day.range}")
    int endDateMonth() {
        return Integer.parseInt(endDateMonth);
    }

    public @Range(min = 1, max = 9999, message = "{start_date.day.range}")
    int endDateYear() {
        return Integer.parseInt(endDateYear);
    }
}
