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
public class Address {
    private String street;
    private String city;
    private String houseNo;
}
