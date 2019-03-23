package data.workers;

import data.dao.TeachersDao;
import data.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
