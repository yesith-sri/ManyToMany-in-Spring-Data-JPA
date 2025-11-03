package bootcamp.edu.crm.repositary;

import bootcamp.edu.crm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositary extends JpaRepository<Student, Long> {
}
