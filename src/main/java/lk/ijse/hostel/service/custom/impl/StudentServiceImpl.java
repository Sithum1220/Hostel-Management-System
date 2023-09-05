package lk.ijse.hostel.service.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.repository.RepositoryFactory;
import lk.ijse.hostel.repository.custom.StudentRepository;
import lk.ijse.hostel.service.custom.StudentService;
import lk.ijse.hostel.utill.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository = RepositoryFactory.getInstance()
            .getRepository(RepositoryFactory.RepositoryType.STUDENT_REPOSITORY);
    private Session session;

    @Override
    public String saveStudent(StudentDTO studentDTO) {
//        session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            studentRepository.setSession(session);
//            String save = studentRepository.save(studentDTO.toEntity());
//            transaction.commit();
//            session.close();
//            return save;
//
//        } catch (Exception e) {
//            transaction.rollback();
//            session.close();
//            return null;
//        }

        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentRepository.setSession(session);
            String save = studentRepository.save(studentDTO.toEntity());
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
    public ObservableList<String> getAllStudentId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ObservableList<String> idList = FXCollections.observableArrayList();
        studentRepository.setSession(session);
        List<String> list = studentRepository.getAllId();
        for (String id : list) {
            idList.add(id);
        }

        transaction.commit();
        session.close();
        return idList;
    }

    @Override
    public String newId(){
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        studentRepository.setSession(session);
       List<String> allId = studentRepository.getAllId();

        String lastId = null;
        for (int i = 0; i < allId.size(); i++) {
            lastId = allId.get(i);
            System.out.println(allId.get(i));
        }
        try {
            String[] e00s = lastId.split("S00");
            int idIndex = Integer.parseInt(e00s[1]);
            idIndex++;
            System.out.println(idIndex);
            transaction.commit();
            session.close();
            return "S00" + idIndex;
        } catch (Exception e) {
            session.close();
            return "S001";
        }

    }
}
