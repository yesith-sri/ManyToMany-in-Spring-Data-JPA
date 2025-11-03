package bootcamp.edu.crm.repositary;

import bootcamp.edu.crm.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CourseRepositary extends JpaRepository<Course, Long> {

}
