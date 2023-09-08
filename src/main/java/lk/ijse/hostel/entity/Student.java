package lk.ijse.hostel.entity;

import  lk.ijse.hostel.embedded.Address;
import lk.ijse.hostel.embedded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    @Column(columnDefinition = "VARCHAR(65)")
    private String studentId;
    private Name name;
    private Address address;
    private String contactNo;
    private LocalDate dob;
    private String gender;

    @OneToMany(mappedBy = "students",fetch = FetchType.EAGER)
    private List<Reservation> reservations = new ArrayList<>();
}
