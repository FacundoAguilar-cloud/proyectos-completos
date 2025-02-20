package com.msvc.courses.msvc_courses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msvc.courses.msvc_courses.entities.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
