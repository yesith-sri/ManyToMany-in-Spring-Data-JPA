package bootcamp.edu.crm.dto;

import bootcamp.edu.crm.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCourseResponse {

    private String name;
    private String email;
    private Set<Course> courseBasicDtos;

}
