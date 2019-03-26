package data.workers;

import data.dao.TeachersDao;
import data.entities.Teacher;
import data.entities.TeacherPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TeachersWorker {
    @Autowired
    private TeachersDao teachersDao;

    public TeachersWorker() {
    }

    public Teacher addTeacher(Teacher teacher) {
        teacher = this.teachersDao.addTeacher(teacher);
        System.out.println(teacher);
        return teacher;
    }

    public List<Teacher> getTeachersByPos(TeacherPosition pos){
        List<Teacher> list = teachersDao.getTeachersByPosition(pos);
        return list;
    }

    public Teacher getTeacher(int id){
        return teachersDao.getTeacher(id);
    }
}
