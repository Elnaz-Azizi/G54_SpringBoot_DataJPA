package se.lexicon.springboot_datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    private boolean status;
    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn(name = "address_id")
    //@JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address address;

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


}
