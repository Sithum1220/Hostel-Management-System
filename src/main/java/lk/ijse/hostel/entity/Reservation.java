package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Reservation {
    @Id
    @Column( columnDefinition = "VARCHAR(65)")
    private String reservationId;
    private LocalDate date;
    private String status;
    @ManyToOne
    private Student students;

    @ManyToOne
    private Room rooms;
}
