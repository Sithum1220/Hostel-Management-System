package lk.ijse.hostel.service.custom.impl;

import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.repository.RepositoryFactory;
import lk.ijse.hostel.repository.custom.ResuvationRepository;
import lk.ijse.hostel.repository.custom.RoomRepository;
import lk.ijse.hostel.service.custom.ResuvationService;
import lk.ijse.hostel.utill.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResuvationServiceImpl implements ResuvationService {
    ResuvationRepository resuvationRepository = RepositoryFactory.getInstance()
            .getRepository(RepositoryFactory.RepositoryType.RESERVATION_REPOSITORY);
    RoomRepository roomRepository = RepositoryFactory.getInstance()
            .getRepository(RepositoryFactory.RepositoryType.ROOM_REPOSITORY);
    private Session session;

    @Override
    public boolean save(ReservationDTO reservationDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(reservationDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String> getAllReservationId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        resuvationRepository.setSession(session);
        try {
            transaction.commit();
            return resuvationRepository.getAllId();
        } catch (Exception e) {
            transaction.rollback();
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
        resuvationRepository.setSession(session);
        List<String> allId = resuvationRepository.getAllId();

        String lastId = null;
        for (int i = 0; i < allId.size(); i++) {
            lastId = allId.get(i);
            System.out.println(allId.get(i));
        }
        try {
            String[] e00s = lastId.split("RE00");
            int idIndex = Integer.parseInt(e00s[1]);
            idIndex++;
            System.out.println(idIndex);
            transaction.commit();
            session.close();
            return "RE00" + idIndex;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            return "RE001";
        }
    }

    @Override
    public ReservationDTO getReservetion(String id) {

        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        resuvationRepository.setSession(session);
        Reservation reservation;
        try {
            reservation = resuvationRepository.get(id);
            transaction.commit();
            session.close();
            return new ReservationDTO(
                    reservation.getReservationId(),
                    reservation.getStudents().getStudentId(),
                    reservation.getRooms().getId(),
                    String.valueOf(reservation.getDate()),
                    reservation.getStatus()
            );

        } catch (Exception e) {
            session.close();
            return null;
        }
    }
}
