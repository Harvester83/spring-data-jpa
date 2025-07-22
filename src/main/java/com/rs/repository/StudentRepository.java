package com.rs.repository;

import com.rs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


  @Query(value = "select * from student", nativeQuery = true)
  List<Student> findAllStudent();
}
