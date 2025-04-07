package se.lexicon.springboot_datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.springboot_datajpa.entity.Student;

import java.util.Optional;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;


    @Test
    @DisplayName("Save Mehrdad")
    void testSaveStudent() {
        Student student = new Student("Mehrdad", "Javan", "mehrdad@lexicon.se");

        Student saved = studentRepository.save(student);

        Assertions.assertNotNull(saved);
    }

    @Test
    @DisplayName("Find by mail - mehrdad@lexicon.se")
    void testFindByEmail() {
        Student student = new Student("Mehrdad", "Javan", "mehrdad@lexicon.se");
        studentRepository.save(student);

        Optional<Student> optionalStudent = studentRepository.findByEmail("mehrdad@lexicon.se");

        Assertions.assertNotNull(optionalStudent);
        // Assertions.assertTrue(optionalStudent.get().getEmail().equals("mehrdad@lexicon.se"));
    }

    // add more tests as needed ... :)

}
