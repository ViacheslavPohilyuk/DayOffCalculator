package dayoff.calc.web.controller;

import dayoff.calc.DayOffCalculation;
import dayoff.calc.data.repo.DateRepository;
import dayoff.calc.model.Holiday;
import dayoff.calc.model.form.DateForm;
import dayoff.calc.web.exception.EndDateLessThanStartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 04.08.17.
 */
@Controller
@RequestMapping(value = "/calc")
public class CalculationController {

    @Autowired
    private DayOffCalculation dayOffCalc;

    @Autowired
    private DateRepository dateRepository;

    @RequestMapping(method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    String getDateForm(Model model) {
        model.addAttribute(new DateForm());
        return "calc";
    }

    @RequestMapping(method = POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String calculateDaysOff(@ModelAttribute("dateForm") @Valid DateForm dateForm,
                                   BindingResult bindingResult, Model model) {
        model.addAttribute(new DateForm());
        if (bindingResult.hasErrors())
            return "calc";

        LocalDate startDate = LocalDate.of(dateForm.startDateYear(),
                dateForm.startDateMonth(),
                dateForm.startDateDay());

        LocalDate endDate = LocalDate.of(dateForm.endDateYear(),
                dateForm.endDateMonth(),
                dateForm.endDateDay());

        if (ChronoUnit.DAYS.between(startDate, endDate) < 0)
            throw new EndDateLessThanStartException();

        boolean isEndDayIncluded = dateForm.isEndDayIncluded();
        long result = dayOffCalc.computeHolidays(startDate, endDate, isEndDayIncluded);

        model.addAttribute("isEndDayIncluded", isEndDayIncluded);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("result", result);
        return "calc";
    }

    @RequestMapping(value = "/holiday", method = POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity saveHoliday(@Valid Holiday holiday) {
        dateRepository.save(holiday);
        return new ResponseEntity<>("New holiday have been successfully saved", HttpStatus.OK);
    }
}
