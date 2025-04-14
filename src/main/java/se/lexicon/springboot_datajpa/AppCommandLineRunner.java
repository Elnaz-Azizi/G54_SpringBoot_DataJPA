package se.lexicon.springboot_datajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.springboot_datajpa.entity.Address;
import se.lexicon.springboot_datajpa.entity.Student;
import se.lexicon.springboot_datajpa.repository.AddressRepository;
import se.lexicon.springboot_datajpa.repository.StudentRepository;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    StudentRepository studentRepository;
    AddressRepository addressRepository;

    public AppCommandLineRunner(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    //@Transactional(rollbackFor = {RuntimeException.class, IllegalArgumentException.class})
    @Override
    public void run(String... args) throws Exception {
/*
        System.out.println("---- WITHOUT CASCADE ----");
        Address address1 = new Address("Gothenburg", "Main Street", "41101");
        Address insertedAddress = addressRepository.save(address1); // address has id
        Student student1 = new Student("Test", "Test", "test@test.se");
        student1.setAddress(address1);

        // Simulate error
        // if (true) throw new RuntimeException("Oops! Something went wrong");


        Student insertedStudent = studentRepository.save(student1);
        System.out.println("insertedStudent.getId() = " + insertedStudent.getId());
        studentRepository.delete(insertedStudent);
        addressRepository.delete(insertedAddress);

        System.out.println("---- WITH CASCADE ----");
        Student student2 = new Student("Test2", "Test2", "test2@test.se");
        Address address2 = new Address("Växjö", "Main Street", "35264");
        student2.setAddress(address2);
        Student insertedStudent2 = studentRepository.save(student2);
        studentRepository.delete(insertedStudent2);
*/

    }

}
