package se.lexicon.springboot_datajpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "createDate")

@Entity
//@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id; // uuid
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    private boolean status;
    private LocalDateTime createDate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    //@JoinColumn(name = "address_id")
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address address;


    @ManyToMany
    @JoinTable(
            name = "students_courses", // name of the join table
            joinColumns = @JoinColumn(name = "student_id"), // foreign key column for the student
            inverseJoinColumns = @JoinColumn(name = "course_id") // foreign key column for the course
    )
    private Set<Course> courses = new HashSet<>(); // 0

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /*
         @PrePersist: This method is called before the entity is persisted (saved) to the database.
         */
    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
        this.status = true;
    }

    public void enrollInCourse(Course course) {
        this.courses.add(course);
        // course.getStudents().add(this);
    }

    public void dropCourse(Course course) {
        this.courses.remove(course);
        //course.getStudents().remove(course);
    }


}
