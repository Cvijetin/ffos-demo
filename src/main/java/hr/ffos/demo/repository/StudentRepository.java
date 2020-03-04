package hr.ffos.demo.repository;

import hr.ffos.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//interface 'StudentRepository' extends JpaRepository so we can access its methods
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //make custom queries
    Student findByLastName(String lastName);

}
