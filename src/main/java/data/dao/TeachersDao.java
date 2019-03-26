package data.dao;

import data.entities.Teacher;
import data.entities.TeacherPosition;

import java.util.List;

public interface TeachersDao {
    Teacher addTeacher(Teacher var1);

    Teacher getTeacher(int var1);

    void saveTeacher(Teacher var1);

    List<Teacher> getTeachersByPosition(TeacherPosition pos);
}
