package bootcamp.edu.crm.service.impl;

import bootcamp.edu.crm.dto.CourseBasicDto;
import bootcamp.edu.crm.entity.Course;
import bootcamp.edu.crm.repositary.CourseRepositary;
import bootcamp.edu.crm.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepositary courseRepositary;

    @Override
    public ResponseEntity<Iterable<Course>> persist(Set<CourseBasicDto> courseBasicDtos) {
        Set<Course> courses = new HashSet<>();

//        courseBasicDtos.stream().filter(courseBasicDto -> {
//            Course course = new Course();
//            course.setTitle(courseBasicDto.getTitle());
//            courses.add(course);
//            return null;
//        }).collect(Collectors.toSet());

        courseBasicDtos.forEach(courseBasicDto -> {
            Course course = new Course();
            course.setTitle(courseBasicDto.getTitle());
            courses.add(course);
        });
        Iterable<Course> courses1 = courseRepositary.saveAll(courses);
        return ResponseEntity.ok().body(courses1);
    }
}
