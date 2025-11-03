package bootcamp.edu.crm.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
public class Student {

    /**
     * The unique identifier for the student.
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
     * The full name of the student.
     */
    private String name;

    /**
     * The email address of the student. This is often used for login
     * and communication, and is typically marked as unique in the database.
     */
    private String email;

    /**
     * The set of courses this student is enrolled in.
     * This field represents the "owning" side of the Many-to-Many relationship.
     *
     * @ManyToMany Defines a many-to-many relationship with the Course entity.
     * @JoinTable Specifies the details of the intermediary table used to link
     * Students and Courses.
     * - name = "join_student_cousre": The name of the join table in the database.
     * - joinColumns = @JoinColumn(name = "student_id"): Defines the foreign key
     * column in the join table that references this entity (Student).
     * - inverseJoinColumns = @JoinColumn(name = "course_id"): Defines the
     * foreign key column in the join table that references the other entity (Course).
     *
     * @JsonManagedReference This annotation is part of the Jackson library, used
     * for serializing this object to JSON. It marks this as the "forward" or
     * "managed" side of the relationship. The 'courses' list will be serialized
     * normally. This works with @JsonBackReference on the 'students' field in the
     * Course class to prevent infinite recursion (Student -> Course -> Student...).
     */
    @ManyToMany
    @JoinTable(
            name = "join_student_cousre",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonManagedReference
        private Set<Course> courses = new HashSet<>();
}
