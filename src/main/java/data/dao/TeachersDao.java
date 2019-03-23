package data.dao;

import data.entities.Teacher;

public interface TeachersDao {
    Teacher addTeacher(Teacher var1);

    Teacher getTeacher(int var1);

    void saveTeacher(Teacher var1);
}
