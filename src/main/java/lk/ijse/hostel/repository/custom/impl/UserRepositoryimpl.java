package lk.ijse.hostel.repository.custom.impl;

import lk.ijse.hostel.entity.User;
import lk.ijse.hostel.repository.custom.UserRepository;
import org.hibernate.Session;

import java.util.List;

public class UserRepositoryimpl implements UserRepository {
    private Session session;


    @Override
    public void delete(User entity) {

    }

    @Override
    public List<String> getAllId() {
        return null;
    }

    @Override
    public String save(User user) {
        return (String) session.save(user);
    }

    @Override
    public void update(User entity) {
         session.update(entity);
    }

    @Override
    public User get(String userName) {
        return session.get(User.class, userName);

    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
