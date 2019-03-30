package data.dao;

import data.entities.Lecture;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
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

    public Lecture saveLecture(Lecture lecture) {
        Lecture createdLecture = null;
        if(lecture != null){
            try{
                em.getTransaction().begin();
                createdLecture = em.merge(lecture);
                em.getTransaction().commit();
            }catch (Exception ex){
                System.out.println("ERROR in Lecture.update: " + ex.getLocalizedMessage());
                em.getTransaction().rollback();
            }finally {
                em.close();
            }
        }
        return createdLecture;
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
