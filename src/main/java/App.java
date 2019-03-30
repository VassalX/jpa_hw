import data.dao.LectureDaoJPAImpl;
import data.dao.TeacherDaoJPAImpl;
import data.dao.TeachersDao;
import data.entities.Lecture;
import data.entities.Teacher;
import data.entities.TeacherPosition;
import data.workers.LecturesWorker;
import data.workers.TeachersWorker;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public App() {
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        Lecture lec1 = new Lecture();
        lec1.setName("Introduction to Spring");
        lec1.setCredits(2.5D);
        lec1.setDate(new Date(System.currentTimeMillis()));

        Lecture lec2 = new Lecture();
        lec2.setName("Web programming");
        lec2.setCredits(3.0D);
        lec2.setDate(new Date(System.currentTimeMillis()));

        Lecture lec3 = new Lecture();
        lec3.setName("Prolog");
        lec3.setCredits(4.0D);
        lec3.setDate(new Date(System.currentTimeMillis()));

        Teacher teacher = new Teacher();
        teacher.setName("Petrenko");
        teacher.setPosition(TeacherPosition.ASSISTANT_PROFESSOR);
        teacher.addLecture(lec3);

        TeachersWorker teachersWorker = (TeachersWorker)context.getBean("teachersWorker");
        LecturesWorker lecturesWorker = (LecturesWorker)context.getBean("lecturesWorker");

        teachersWorker.saveTeacher(teacher);
        lecturesWorker.saveLecture(lec3);

        teachersWorker.getTeachersByPos(TeacherPosition.PROFESSOR);
        teachersWorker.getTeachersByPos(TeacherPosition.PROFESSOR);
        teachersWorker.getTeachersByPos(TeacherPosition.PROFESSOR);
        List<Teacher> tea_list = teachersWorker.getTeachersByPos(TeacherPosition.ASSISTANT_PROFESSOR);

        for (Teacher t : tea_list) {
            System.out.println(t.getName());
        }

        System.out.println(TeacherDaoJPAImpl.getTeacherCount);

        lecturesWorker.getLecturesByTeacher("Pavlenko");
        lecturesWorker.getLecturesByTeacher("Pavlenko");
        lecturesWorker.getLecturesByTeacher("Pavlenko");
        List<Lecture> lec_list = lecturesWorker.getLecturesByTeacher("Pavlenko");

        for (Lecture l : lec_list) {
            System.out.println(l.getName());
        }

        System.out.println(LectureDaoJPAImpl.getLectureCount);
    }
}
