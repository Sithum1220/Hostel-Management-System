package lk.ijse.hostel.service;

import lk.ijse.hostel.service.custom.impl.ResuvationServiceImpl;
import lk.ijse.hostel.service.custom.impl.RoomServiceImpl;
import lk.ijse.hostel.service.custom.impl.StudentServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }

    public enum ServiceType{
        STUDENT_SERVICE,ROOM_SERVICE,RESERVATION_SERVICE
    }

    public <T extends SuperService>T getServiceFactory(ServiceType serviceType){
        switch (serviceType){
            case STUDENT_SERVICE:
                return (T) new StudentServiceImpl();
            case ROOM_SERVICE:
                return (T) new RoomServiceImpl();
            case RESERVATION_SERVICE:
                return (T) new ResuvationServiceImpl();
            default:
                return null;
        }
    }
}
