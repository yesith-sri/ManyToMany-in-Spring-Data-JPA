package bootcamp.edu.crm.service;

import bootcamp.edu.crm.dto.CourseBasicDto;
import bootcamp.edu.crm.dto.StudentCourseRequest;
import bootcamp.edu.crm.dto.StudentCourseResponse;
import bootcamp.edu.crm.entity.Course;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface StudentService {
    ResponseEntity<StudentCourseResponse> persistStu(StudentCourseRequest studentCourseRequest);
}
