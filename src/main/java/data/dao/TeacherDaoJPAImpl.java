package data.dao;

import data.entities.Lecture;
import data.entities.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class TeacherDaoJPAImpl implements TeachersDao{
    @PersistenceContext
    private EntityManager em;

    public Teacher addTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }

    public Teacher getTeacher(int id) {
        return em.find(Teacher.class,id);
    }

    public void saveTeacher(Teacher teacher) {
        em.merge(teacher);
    }
}
