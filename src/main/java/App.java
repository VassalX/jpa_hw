import data.entities.Lecture;
import data.entities.Teacher;
import data.entities.TeacherPosition;
import data.workers.LecturesWorker;
import data.workers.TeachersWorker;
import java.util.Date;
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

        Teacher teacher = new Teacher();
        teacher.setName("Pavlenko");
        teacher.setPosition(TeacherPosition.PROFESSOR);
        teacher.addLecture(lec1);
        teacher.addLecture(lec2);

        TeachersWorker teachersWorker = (TeachersWorker)context.getBean("teachersWorker");
        LecturesWorker lecturesWorker = (LecturesWorker)context.getBean("lecturesWorker");

        teachersWorker.addTeacher(teacher);

        lecturesWorker.addLecture(lec1);
        lecturesWorker.addLecture(lec2);
    }
}
