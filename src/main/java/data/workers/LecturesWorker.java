package data.workers;

import data.dao.LecturesDao;
import data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LecturesWorker {
    @Autowired
    private LecturesDao lecturesDao;

    public LecturesWorker() {
    }

    public Lecture addLecture(Lecture lecture) {
        lecture = this.lecturesDao.addLecture(lecture);
        System.out.println(lecture);
        return lecture;
    }

    public List<Lecture> getLecturesByTeacher(String name){
        List<Lecture> list = lecturesDao.getLecturesByTeacher(name);
        return list;
    }
}
