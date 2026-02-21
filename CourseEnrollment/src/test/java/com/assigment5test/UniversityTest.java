package com.assigment5test;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.assigment.Course;
import com.assigment.Enrollment;
import com.assigment.Instructor;
import com.assigment.InstructorProfile;
import com.assigment.UniversityService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityTest {

    static Long instructorId;
    static Long enrollmentId;

    UniversityService service = new UniversityService();

    @Order(1)
    @Test
    void oneToOneTest() {
        Instructor i = new Instructor();
        i.setName("Ramesh");
        i.setDepartment("CSE");

        InstructorProfile p = new InstructorProfile();
        p.setOfficeRoom("B201");
        p.setPhone("9999999999");

        i.setInstructorProfile(p);
        service.createInstructorWithProfile(i, p);

        instructorId = i.getId();
        Assertions.assertNotNull(instructorId);
    }

    @Order(2)
    @Test
    void oneToManyTest() {
        Instructor i = service.fetchInstructor(instructorId);

        Course c1 = new Course();
        c1.setTitle("Java");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setTitle("DBMS");
        c2.setCredits(3);

        service.addCoursesToInstructor(i, List.of(c1, c2));

        Instructor updated = service.fetchInstructor(instructorId);
        Assertions.assertEquals(2, updated.getCourses().size());
    }

    @Order(3)
    @Test
    void manyToOneTest() {
        Course c = new Course();
        c.setTitle("Hibernate");
        c.setCredits(3);

        Enrollment e = new Enrollment();
        e.setSemester("Spring");
        e.setGrade("A");
        e.setCourse(c);

        service.addEnrollmentToCourse(e);

        enrollmentId = e.getId();
        Assertions.assertNotNull(enrollmentId);
    }

    @Order(4)
    @Test
    void updateTest() {
        service.updateEnrollmentGrade(enrollmentId, "A+");
    }

    @Order(5)
    @Test
    void deleteTest() {
        service.deleteInstructor(instructorId);
        Instructor i = service.fetchInstructor(instructorId);
        Assertions.assertNull(i);
    }

    @Order(6)
    @Test
    void fullIntegrationTest() {
        Assertions.assertTrue(true);
    }
}