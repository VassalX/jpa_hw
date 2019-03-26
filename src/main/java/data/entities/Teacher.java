package data.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "selectTeachersByPos",
                query="select t from Teacher t where t.position = :pos")
})
@Cacheable(true)
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
