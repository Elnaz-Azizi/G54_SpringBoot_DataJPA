package se.lexicon.springboot_datajpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.springboot_datajpa.entity.Student;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameAndLastNameContainsIgnoreCase(String firstName, String lastName);
    Optional<Student> findByEmail(String email);

}
