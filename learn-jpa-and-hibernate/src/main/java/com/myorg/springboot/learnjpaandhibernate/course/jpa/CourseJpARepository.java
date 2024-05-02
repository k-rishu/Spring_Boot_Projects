package com.myorg.springboot.learnjpaandhibernate.course.jpa;

import com.myorg.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpARepository {

//    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course coures){
        entityManager.merge(coures);
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
