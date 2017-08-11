package dayoff.calc.model.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

/**
 * Created by mac on 08.08.17.
 */
@Data
@NoArgsConstructor
public class DateForm {

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 31)
    int startDateDay;

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 12)
    int startDateMonth;

    @Pattern(regexp = "^[0-9]{4}")
    @Range(min = 1, max = 9999)
    int startDateYear;

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 31)
    int endDateDay;

    @Pattern(regexp = "^[0-9]{2}")
    @Range(min = 1, max = 12)
    int endDateMonth;

    @Pattern(regexp = "^[0-9]{4}")
    @Range(min = 1, max = 9999)
    int endDateYear;
}
