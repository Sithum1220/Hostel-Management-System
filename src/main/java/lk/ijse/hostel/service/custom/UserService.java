package lk.ijse.hostel.service.custom;

import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.service.SuperService;

public interface UserService extends SuperService {
     String save(UserDTO userDTO);
     UserDTO get(String userName);
     boolean update(UserDTO userDTO) ;
    }
