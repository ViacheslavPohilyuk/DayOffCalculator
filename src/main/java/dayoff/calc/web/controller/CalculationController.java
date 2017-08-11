package dayoff.calc.web.controller;

import dayoff.calc.DayOffCalculation;
import dayoff.calc.data.repo.DateRepository;
import dayoff.calc.model.form.DateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mac on 04.08.17.
 */
@Controller
@RequestMapping(value = "/calc")
public class CalculationController {

    @Autowired
    DateRepository dateRepository;

    @Autowired
    DayOffCalculation dayOffCalc;

    @RequestMapping(method = GET)
    String getDateForm(Model model) {
        model.addAttribute(new DateForm());
        return "calc";
    }

    @RequestMapping(method = POST)
    //@PreAuthorize("hasRole('ROLE_USER')")
    public String calculateDaysOff(DateForm dateForm, Model model) {
        System.out.println("DateForm: { " + dateForm.toString() + "}");

        LocalDate startDate = LocalDate.of(dateForm.getStartDateYear(),
                dateForm.getStartDateMonth(),
                dateForm.getStartDateDay());

        LocalDate endDate = LocalDate.of(dateForm.getEndDateYear(),
                dateForm.getEndDateMonth(),
                dateForm.getEndDateDay());

        long result = dayOffCalc.computeWeekendsCount(startDate, endDate);

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("result", result);
        return "calc";
    }
}
