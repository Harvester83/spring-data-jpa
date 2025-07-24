package com.rs.repository;

import com.rs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

  @Query(value = "from Student", nativeQuery = false)
  List<Student> findAllStudent();

  @Query(value = "from Student s WHERE s.sid = :studentId", nativeQuery = false)
  Optional<Student> findStudentById(Integer studentId);
}
