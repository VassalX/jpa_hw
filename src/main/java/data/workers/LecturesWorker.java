package data.workers;

import data.dao.LecturesDao;
import data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LecturesWorker {
    @Autowired
    private LecturesDao lecturesDao;

    public LecturesWorker() {
    }

    public void saveLecture(Lecture lecture) {
        lecture = this.lecturesDao.addLecture(lecture);
        System.out.println(lecture);
    }

    public List<Lecture> getLecturesByTeacher(String name){
        List<Lecture> list = lecturesDao.getLecturesByTeacher(name);
        return list;
    }
}
