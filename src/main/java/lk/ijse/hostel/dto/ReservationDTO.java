package lk.ijse.hostel.dto;

import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ReservationDTO {

    private String resNo;
    private String sId;
    private String rId;
    private LocalDate date;
    private String status;

    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setReservationId(this.rId);
        reservation.setDate(this.date);
        reservation.setStatus(this.status);

        Student student = new Student();
        student.setStudentId(this.sId);
        reservation.setStudents(student);

        Room room = new Room();
        room.setId(this.rId);
        reservation.setRooms(room);

        return reservation;
    }
}
