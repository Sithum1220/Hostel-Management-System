package lk.ijse.hostel.repository;

import lk.ijse.hostel.repository.custom.impl.RoomRepositoryImpl;
import lk.ijse.hostel.repository.custom.impl.StudentRepositoryImpl;

public class RepositoryFactory {

    private static RepositoryFactory repositoryFactory;
    private RepositoryFactory(){}

    public static RepositoryFactory getInstance(){
        return repositoryFactory == null ? repositoryFactory = new RepositoryFactory() : repositoryFactory;
    }

    public enum RepositoryType{
        STUDENT_REPOSITORY, ROOM_REPOSITORY
    }

    public <T extends SuperRepository>T getRepository(RepositoryType repositoryType){
        switch (repositoryType){
            case STUDENT_REPOSITORY:
                return (T) new StudentRepositoryImpl();
            case ROOM_REPOSITORY:
                return (T) new RoomRepositoryImpl();
            default:
                return null;
        }
    }
}