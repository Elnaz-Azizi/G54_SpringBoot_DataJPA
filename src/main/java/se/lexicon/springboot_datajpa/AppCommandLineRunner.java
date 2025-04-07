package se.lexicon.springboot_datajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.springboot_datajpa.entity.Student;
import se.lexicon.springboot_datajpa.repository.StudentRepository;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    StudentRepository studentRepository;

    public AppCommandLineRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, World!");
      //  Student student1 = new Student("Test","Test", "test@test.se");
      //  Student insertedStudent = studentRepository.save(student1);
      //  System.out.println("insertedStudent.getId() = " + insertedStudent.getId());

    }

}
