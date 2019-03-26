package data.dao;

import data.entities.Lecture;

import java.util.List;

public interface LecturesDao {
    data.entities.Lecture addLecture(data.entities.Lecture lecture);

    data.entities.Lecture getLecture(int i);

    void saveLecture(data.entities.Lecture lecture);

    List<Lecture> getLecturesByTeacher(String name);
}