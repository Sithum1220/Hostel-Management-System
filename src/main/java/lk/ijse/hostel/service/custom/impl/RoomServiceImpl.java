package lk.ijse.hostel.service.custom.impl;

import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.repository.RepositoryFactory;
import lk.ijse.hostel.repository.custom.RoomRepository;
import lk.ijse.hostel.repository.custom.StudentRepository;
import lk.ijse.hostel.service.custom.RoomService;
import lk.ijse.hostel.utill.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    RoomRepository roomRepository = RepositoryFactory.getInstance()
            .getRepository(RepositoryFactory.RepositoryType.ROOM_REPOSITORY);
    private Session session;
    @Override
    public String saveRoom(RoomDTO roomDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomRepository.setSession(session);
            String save = roomRepository.save(roomDTO.toEntity());
            transaction.commit();
            session.close();
            return save;

        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            return null;
        }
    }

    @Override
    public List<String> getAllRoomId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        roomRepository.setSession(session);
        try {
            transaction.commit();
            return roomRepository.getAllId();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public String newId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        roomRepository.setSession(session);
        List<String> allId = roomRepository.getAllId();

        String lastId = null;
        for (int i = 0; i < allId.size(); i++) {
            lastId = allId.get(i);
            System.out.println(allId.get(i));
        }
        try {
            String[] e00s = lastId.split("R00");
            int idIndex = Integer.parseInt(e00s[1]);
            idIndex++;
            System.out.println(idIndex);
            transaction.commit();
            session.close();
            return "R00" + idIndex;
        } catch (Exception e) {
            session.close();
            return "R001";
        }
    }

    @Override
    public RoomDTO getRoom(String id) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        roomRepository.setSession(session);
        Room room;
        try {
            room = roomRepository.get(id);
            transaction.commit();
            session.close();
            return new RoomDTO(
                    room.getId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()
            );
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return null;
        }
    }
}
