package data.dao;

public interface LecturesDao {
    data.entities.Lecture addLecture(data.entities.Lecture lecture);

    data.entities.Lecture getLecture(int i);

    void saveLecture(data.entities.Lecture lecture);
}