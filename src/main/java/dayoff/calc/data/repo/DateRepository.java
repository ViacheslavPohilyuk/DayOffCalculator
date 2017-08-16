package dayoff.calc.data.repo;

import dayoff.calc.data.SessionExecutor;
import dayoff.calc.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Holiday> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<Holiday>(s.createCriteria(Holiday.class).list()));
    }
}
