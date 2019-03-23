package data.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "teachers"
)
public class Teacher {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "ID"
    )
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TeacherPosition position;
    @OneToMany(
            mappedBy = "teacher"
    )
    private List<Lecture> lectures = new ArrayList();

    public Teacher() {
    }

    public Teacher(String name, TeacherPosition position, List<Lecture> lectures) {
        this.name = name;
        this.position = position;
        this.lectures = lectures;
    }

    public void addLecture(Lecture lec) {
        this.lectures.add(lec);
        lec.setTeacher(this);
    }

    public void removeLecture(Lecture lec) {
        this.lectures.remove(lec);
        lec.setTeacher((Teacher)null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherPosition getPosition() {
        return this.position;
    }

    public void setPosition(TeacherPosition position) {
        this.position = position;
    }

    public List<Lecture> getLectures() {
        return this.lectures;
    }
}
