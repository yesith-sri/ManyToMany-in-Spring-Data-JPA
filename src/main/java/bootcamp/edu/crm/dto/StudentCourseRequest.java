package bootcamp.edu.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseRequest {

    private String name;
    private String email;
    private Set<Long> courseIds;
}
