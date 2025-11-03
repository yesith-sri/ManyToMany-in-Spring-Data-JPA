package bootcamp.edu.crm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Course {
    /**
     * The unique identifier for the course.
     *
     * @Id Specifies this field is the primary key of the entity.
     * @GeneratedValue(strategy = GenerationType.IDENTITY) Configures the ID generation
     * strategy. IDENTITY delegates the responsibility of auto-incrementing
     * the value to the database upon insertion.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the course (e.g., "Introduction to Java").
     */
    private String title;

    /**
     * The set of students enrolled in this course.
     * This field represents the "inverse" (non-owning) side of the
     * Many-to-Many relationship.
     *
     * @ManyToMany(mappedBy = "courses") Defines this as the "inverse" side.
     * The 'mappedBy = "courses"' attribute tells JPA that the relationship
     * is already configured by the 'courses' field in the 'Student' entity.
     * JPA will not create a separate join table for this side.
     *
     * @JsonBackReference This annotation is part of the Jackson library, used
     * for serializing this object to JSON. It marks this as the "back"
     * reference. When serializing a Course, this 'students' list will be
     * *omitted* from the JSON output. This prevents an infinite recursion
     * loop (where Student serializes Course, which serializes Student, and so on).
     */
    @ManyToMany(mappedBy = "courses")
    @JsonBackReference
    private Set<Student> students = new HashSet<>();
}
