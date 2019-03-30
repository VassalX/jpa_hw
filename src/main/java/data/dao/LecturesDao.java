package data.dao;

import data.entities.Lecture;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface LecturesDao {
    data.entities.Lecture addLecture(data.entities.Lecture lecture);

    data.entities.Lecture getLecture(int i);

    Lecture saveLecture(data.entities.Lecture lecture);

    List<Lecture> getLecturesByTeacher(String name);
}