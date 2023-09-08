package lk.ijse.hostel.service;

import lk.ijse.hostel.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }

    public enum ServiceType{
        STUDENT_SERVICE,ROOM_SERVICE,RESERVATION_SERVICE,DASHBOARD_SERVICE,QUARY_SERVICE, USER_Service
    }

    public <T extends SuperService>T getServiceFactory(ServiceType serviceType){
        switch (serviceType){
            case STUDENT_SERVICE:
                return (T) new StudentServiceImpl();
            case ROOM_SERVICE:
                return (T) new RoomServiceImpl();
            case RESERVATION_SERVICE:
                return (T) new ResuvationServiceImpl();
            case DASHBOARD_SERVICE:
                return (T) new DashboardServiceImpl();
            case QUARY_SERVICE:
                return (T) new QueryServiceimpl();
            case USER_Service:
                return (T) new UserServiceimpl();
            default:
                return null;
        }
    }
}
