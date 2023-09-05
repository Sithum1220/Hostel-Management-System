package lk.ijse.hostel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @Column(name = "room_id", columnDefinition = "VARCHAR(65)")
    private String id;
    @Column(name = "room_type")
    private String type;
    @Column(name = "key_money")
    private String keyMoney;
    @Column(name = "quantity")
    private int qty;

    @OneToMany(mappedBy = "rooms",targetEntity = Reservation.class , cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
}
