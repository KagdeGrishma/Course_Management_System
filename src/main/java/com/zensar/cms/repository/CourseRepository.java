package com.zensar.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.cms.model.Course;

/**
 * @author Grishma Kagde
 *
 * Repository for course table in DB.
 */
public interface CourseRepository extends JpaRepository<Course, Integer>{

	/**
	 * fetch all course with status active
	 * @param active
	 * @return list of {@link Course}
	 */
	List<Course> findByActive(String active);

	/**
	 * fetch course with CourseId
	 * @param courseId
	 * @return course 
	 */
	Course findByCourseId(Integer courseId);

}
