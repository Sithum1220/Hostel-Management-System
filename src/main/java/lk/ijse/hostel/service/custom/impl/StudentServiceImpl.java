package lk.ijse.hostel.service.custom.impl;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Student;
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
    public List<String> getAllStudentId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        studentRepository.setSession(session);
        try {
            transaction.commit();
            return studentRepository.getAllId();
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
            transaction.rollback();
            session.close();
            return "S001";
        }

    }

    @Override
    public StudentDTO getStudent(String id) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        studentRepository.setSession(session);
        Student student;
        try {
            student = studentRepository.get(id);
            transaction.commit();
            session.close();
            return new StudentDTO(
                    student.getStudentId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContactNo(),
                    student.getDob(),
                    student.getGender()
            );
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    @Override
    public List<String> getSearchStudentId() {
//        session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        studentRepository.setSession(session);
        return null;
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentRepository.setSession(session);
            studentRepository.update(studentDTO.toEntity());
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

    @Override
    public boolean delete(StudentDTO studentDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentRepository.setSession(session);
            studentRepository.delete(studentDTO.toEntity());
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
