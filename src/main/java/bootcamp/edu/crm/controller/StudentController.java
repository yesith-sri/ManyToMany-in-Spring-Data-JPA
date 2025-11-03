package bootcamp.edu.crm.controller;

import bootcamp.edu.crm.dto.CourseBasicDto;
import bootcamp.edu.crm.dto.StudentCourseRequest;
import bootcamp.edu.crm.dto.StudentCourseResponse;
import bootcamp.edu.crm.entity.Course;
import bootcamp.edu.crm.service.CourseService;
import bootcamp.edu.crm.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/stduent")
@RequiredArgsConstructor
public class StudentController {



    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentCourseResponse> persistStu(@RequestBody StudentCourseRequest studentCourseRequest) {
        return studentService.persistStu(studentCourseRequest);
    }
}
