package bootcamp.edu.crm.service.impl;


import bootcamp.edu.crm.dto.StudentCourseRequest;
import bootcamp.edu.crm.dto.StudentCourseResponse;
import bootcamp.edu.crm.entity.Course;
import bootcamp.edu.crm.entity.Student;
import bootcamp.edu.crm.repositary.CourseRepositary;
import bootcamp.edu.crm.repositary.StudentRepositary;
import bootcamp.edu.crm.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepositary studentRepositary;
    private final CourseRepositary courseRepositary;

    @Override
    public ResponseEntity<StudentCourseResponse> persistStu(StudentCourseRequest studentCourseRequest) {
        Student student = new Student();

        student.setName(studentCourseRequest.getName());
        student.setEmail(studentCourseRequest.getEmail());


        HashSet<Course> coursesHashSet = new HashSet<>();
        Iterable<Course> courses = courseRepositary.findAllById(studentCourseRequest.getCourseIds());
        courses.forEach(course -> {
           course.setStudents(Set.of(student));
           coursesHashSet.add(course);
        });

        student.setCourses(coursesHashSet);
        Student save = studentRepositary.save(student);


        return ResponseEntity.ok(
                StudentCourseResponse.builder()
                        .name(save.getName())
                        .email(save.getEmail())
                        .courseBasicDtos(save.getCourses())
                        .build()
        );

    }
}
