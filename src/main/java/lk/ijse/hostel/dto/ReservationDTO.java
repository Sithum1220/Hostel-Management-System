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
    private String date;
    private String status;

    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setReservationId(this.resNo);
        reservation.setDate(LocalDate.parse(this.date));
        reservation.setStatus(this.status);

        Student student = new Student();
        student.setStudentId(this.sId);
        reservation.setStudents(student);

        Room room = new Room();
        room.setId(this.rId);
        reservation.setRooms(room);


        System.out.println(this.resNo);
        System.out.println(this.sId);
        System.out.println(this.rId);
        System.out.println(this.date);
        System.out.println(this.status);
        return reservation;
    }
}
