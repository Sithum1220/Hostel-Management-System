package lk.ijse.hostel.service.custom.impl;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.repository.RepositoryFactory;
import lk.ijse.hostel.repository.custom.DashboardRepository;
import lk.ijse.hostel.service.custom.QueryService;
import lk.ijse.hostel.utill.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.List;

public class QueryServiceimpl implements QueryService {

    private DashboardRepository dashboardRepository = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.DASHBOARD_REPOSITORY);

    private Session session;

    public List<StudentDTO> getAllPendingPaymentStudent() {
        session = SessionFactoryConfig.getInstance().getSession();
        dashboardRepository.setSession(session);
        return dashboardRepository.getAllPendingPaymentStudent();
    }
}
