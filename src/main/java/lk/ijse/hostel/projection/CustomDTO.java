package lk.ijse.hostel.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomDTO {
    private String studentId;
    private String roomId;
    private String roomType;
    private String studentName;
    private String status;
    private String date;
}
