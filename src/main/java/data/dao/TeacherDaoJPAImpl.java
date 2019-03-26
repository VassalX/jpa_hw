package data.dao;

import data.entities.Teacher;
import data.entities.TeacherPosition;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoJPAImpl implements TeachersDao{

    @PersistenceContext
    private EntityManager em;

    public static int getTeacherCount = 0;

    public Teacher addTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }

    public Teacher getTeacher(int id) {
        return em.find(Teacher.class,id);
    }
    @Cacheable("teachersCache")
    public List<Teacher> getTeachersByPosition(TeacherPosition pos){
        getTeacherCount++;
        return em.createNamedQuery(
                "selectTeachersByPos", Teacher.class)
                .setParameter("pos",pos)
                .getResultList();
    }

    public void saveTeacher(Teacher teacher) {
        em.merge(teacher);
    }
}
