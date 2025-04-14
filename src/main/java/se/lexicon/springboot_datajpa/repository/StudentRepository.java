package se.lexicon.springboot_datajpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.springboot_datajpa.entity.Student;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameAndLastNameContainsIgnoreCase(String firstName, String lastName);

    Optional<Student> findByEmail(String email);

    List<Student> findByStatusTrue();

    List<Student> findByAddress_City(String addressCity);

    Optional<Student> findByAddress_Id(Long addressId);


    // SQL: Select * from student where first_name = ?
    // JPQL: Select s from Student s where s.firstName = ?
    //@Query(value = "SELECT * FROM student WHERE first_name = :firstName", nativeQuery = true)
    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName")
    List<Student> selectStudentsByStudentFirstName(@Param("firstName") String firstName);


    // @Modifying annotation tells Spring Data JPA that this query will modify the database (Not a SELECT Query).
    @Modifying // This annotation is required for update/delete operations
    @Query("UPDATE Student s SET s.status = :status WHERE s.id = :id")
    int updateStudentStatusById(@Param("id") String id, @Param("status") boolean status);

}
