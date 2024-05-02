package com.myorg.springboot.learnjpaandhibernate.course.jdbc;

import com.myorg.springboot.learnjpaandhibernate.course.Course;
import com.myorg.springboot.learnjpaandhibernate.course.jpa.CourseJpARepository;
import com.myorg.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJDBCRepository repository;
//
//    @Autowired
//    private CourseJpARepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn Java", "in28minutes"));
        repository.save(new Course(2, "Learn AWS", "in28minutes"));
        repository.save(new Course(3, "Learn Git", "in28minutes"));
        repository.save(new Course(4, "Learn Azure", "in28minutes"));
        repository.deleteById(4l);

        System.out.println(repository.findById(3l));


    }
}
