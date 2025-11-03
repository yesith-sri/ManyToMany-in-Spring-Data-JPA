package bootcamp.edu.crm.service;

import bootcamp.edu.crm.dto.CourseBasicDto;
import bootcamp.edu.crm.entity.Course;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CourseService {
    ResponseEntity<Iterable<Course>> persist(Set<CourseBasicDto> courseBasicDtos);
}
