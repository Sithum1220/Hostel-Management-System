package lk.ijse.hostel.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Name {

    private String first_name;
    private String last_name;
}
