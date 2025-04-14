package se.lexicon.springboot_datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "students") // Exclude students from equals and hashCode
@ToString(exclude = "students") // Exclude students from toString

//@Data // @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    //@ManyToMany(mappedBy = "courses")
    //private Set<Student> students = new HashSet<>(); // 0

}
