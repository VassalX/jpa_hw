package data.dao;

import data.entities.Lecture;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class LectureDaoJPAImpl implements LecturesDao{
    public static int getLectureCount = 0;

    @PersistenceContext
    private EntityManager em;

    public Lecture addLecture(Lecture lecture) {
        em.persist(lecture);
        return lecture;
    }

    public Lecture getLecture(int id) {
        return em.find(Lecture.class,id);
    }

    public void saveLecture(Lecture lecture) {
        em.merge(lecture);
    }

    @Cacheable("lecturesCache")
    public List<Lecture> getLecturesByTeacher(String name){
        getLectureCount++;
        return em.createNamedQuery(
                "selectLecturesByTeacher", Lecture.class)
                .setParameter("name",name)
                .getResultList();
    }
}
