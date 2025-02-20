package com.msvc.courses.msvc_courses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.courses.msvc_courses.Dto.StudentDTO;
import com.msvc.courses.msvc_courses.clients.StudentClient;
import com.msvc.courses.msvc_courses.entities.Course;
import com.msvc.courses.msvc_courses.httpResponse.StudentsByCourseResponse;
import com.msvc.courses.msvc_courses.repository.CourseRepository;
@Service
public class CourseServiceIMP implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentClient studentClient;

    @Override
    public List<Course> getAllCourses() {
        return(List<Course>) courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course createCourse(Course course) {
      return courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long id) {
       courseRepository.deleteById(id);
    }

    @Override
    public StudentsByCourseResponse findStudentsByIdCourse(Long courseId) {
        //consultamos el curso
        Course course = courseRepository.findById(courseId).orElse(new Course());

        //obtener los estudiantes
        List <StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(courseId);
        
        
        return StudentsByCourseResponse.builder()
        .courseName(course.getCourse())
        .teacher(course.getTeacher())
        .studentDTOList(studentDTOList)
        .build();

    }

}
