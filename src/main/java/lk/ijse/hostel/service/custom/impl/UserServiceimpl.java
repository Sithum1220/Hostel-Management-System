package lk.ijse.hostel.service.custom.impl;

import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.entity.User;
import lk.ijse.hostel.repository.RepositoryFactory;
import lk.ijse.hostel.repository.custom.UserRepository;
import lk.ijse.hostel.service.custom.UserService;
import lk.ijse.hostel.utill.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserServiceimpl implements UserService {

    private UserRepository userRepository = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.USER_REPOSITORY);

    private Session session;

    @Override
    public String save(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            String save = userRepository.save(userDTO.toEntity());
            transaction.commit();
            session.close();

            return save;


        } catch (Exception ex) {
            transaction.rollback();
            session.close();


            return null;
        }
    }

    public UserDTO get(String userName) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {
            userRepository.setSession(session);
            User user = userRepository.get(userName);
            return new UserDTO(
                    user.getUserName(),
                    user.getPassWord()
            );
        } catch (NullPointerException e) {
            return null;
        } finally {
            session.close();
        }

    }

    public boolean update(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.update(userDTO.toEntity());
            transaction.commit();
            session.close();

            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();

            return false;
        }
    }
}
