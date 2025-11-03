package bootcamp.edu.crm.controller;

import bootcamp.edu.crm.dto.CourseBasicDto;
import bootcamp.edu.crm.entity.Course;
import bootcamp.edu.crm.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Iterable<Course>> persist(@RequestBody Set<CourseBasicDto>courseBasicDtos) {
        return courseService.persist(courseBasicDtos);
    }

}