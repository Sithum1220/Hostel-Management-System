package lk.ijse.hostel.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudRepository <T,ID> extends SuperRepository{

    ID save(T t);
    void update(T t);

    T get (ID id);

    void delete(T Objec);
    List<ID> getAllId();


}
