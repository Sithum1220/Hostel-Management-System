package lk.ijse.hostel.service.custom.impl;

import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.repository.RepositoryFactory;
import lk.ijse.hostel.repository.custom.DashboardRepository;
import lk.ijse.hostel.repository.custom.RoomRepository;
import lk.ijse.hostel.repository.custom.StudentRepository;
import lk.ijse.hostel.service.custom.DashboardService;
import lk.ijse.hostel.utill.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;

public class DashboardServiceImpl implements DashboardService {

    private StudentRepository studentRepository = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.STUDENT_REPOSITORY);
    private RoomRepository roomRepository = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOM_REPOSITORY);
    private DashboardRepository dashboardRepository= RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.DASHBOARD_REPOSITORY);

    private Session session;
    @Override
    public Long getPendingPaymentCount() {
        session = SessionFactoryConfig.getInstance().getSession();
        dashboardRepository.setSession(session);
        Long allPendingPaymentCount = dashboardRepository.getAllPendingPaymentCount();
        if(allPendingPaymentCount == null){
            return Long.valueOf(0);
        }else {
            return allPendingPaymentCount;
        }
    }

    @Override
    public int getRoomCount() {
        ArrayList<Room> rooms;
        session = SessionFactoryConfig.getInstance().getSession();
        roomRepository.setSession(session);
        rooms = roomRepository.getAllRooms();
        int count = 0;
        for (Room r : rooms) {
            count += r.getQty();
        }
        System.out.println(count);
        return count;
    }
}
