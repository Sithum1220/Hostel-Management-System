package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Room {
    @Id
    @Column(columnDefinition = "VARCHAR(65)")
    private String id;
    private String type;
    private String keyMoney;
    private int qty;

    @OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
}
