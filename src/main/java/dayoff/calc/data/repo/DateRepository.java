package dayoff.calc.data.repo;

import dayoff.calc.data.SessionExecutor;
import dayoff.calc.model.DayOff;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by mac on 28.07.17.
 */
@Service
public class DateRepository {

    private SessionExecutor sessionExecutor;

    @Autowired
    public DateRepository(SessionExecutor sessionExecutor) {
        this.sessionExecutor = sessionExecutor;
    }

    public List<DayOff> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<DayOff>(
                s.createQuery("SELECT MONTH(holiday), Day(holiday) from Holiday").list()));
    }
}
