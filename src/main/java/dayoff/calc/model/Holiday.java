package dayoff.calc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mac on 02.08.17.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "holidays")
public class Holiday implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    @Range(min = 1, max = 12)
    int month;

    @Column(name = "day")
    @Range(min = 1, max = 31)
    int day;

    public Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }
}
