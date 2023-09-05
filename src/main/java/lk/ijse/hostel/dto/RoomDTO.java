package lk.ijse.hostel.dto;

import lk.ijse.hostel.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomDTO {

    private String id;
    private String type;
    private String keyMoney;
    private int qty;

    public Room toEntity(){
        Room room = new Room();
        room.setId(this.id);
        room.setType(this.type);
        room.setKeyMoney(this.keyMoney);
        room.setQty(this.qty);
        return room;
    }
}
