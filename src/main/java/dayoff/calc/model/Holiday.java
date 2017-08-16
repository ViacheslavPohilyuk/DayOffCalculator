package dayoff.calc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mac on 02.08.17.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "holidays"
        /* , uniqueConstraints =
        @UniqueConstraint(columnNames = {"day1", "month1"}) */)
public class Holiday implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    int month;

    @Column(name = "day")
    int day;

    public Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }
}
