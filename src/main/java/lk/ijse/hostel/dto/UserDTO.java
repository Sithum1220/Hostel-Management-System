package lk.ijse.hostel.dto;

import lk.ijse.hostel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private String UserName;
    private String PassWord;

    public User toEntity(){
        User user = new User();
        user.setUserName(this.UserName);
        user.setPassWord(this.PassWord);
        return user;
    }
}
