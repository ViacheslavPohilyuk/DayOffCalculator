package dayoff.calc.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mac on 02.08.17.
 */
@Entity
@Table(name = "holidays")
public class Holiday {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "holiday")
    @Type(type = "date")
    Date holiday;
}
