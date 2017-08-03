package dayoff.calc.data;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by mac on 28.07.17.
 */
@Service
public class DataService {

    private SessionExecutor sessionExecutor;

    @Autowired
    public DataService(SessionExecutor sessionExecutor) {
        this.sessionExecutor = sessionExecutor;
    }

   /* public TextFile getTextFile(long id) {
        return sessionExecutor.readSession((s) -> (TextFile) s.get(TextFile.class, id));
    }

    public Collection<TextFile> getAllTextFiles() {
        return sessionExecutor.readSession((s) -> new LinkedHashSet(s.createCriteria(TextFile.class)
                .addOrder(Order.desc("id"))
                .list()));
    } */
}
