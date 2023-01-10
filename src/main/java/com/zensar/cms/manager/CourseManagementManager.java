package com.zensar.cms.manager;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zensar.cms.dto.RequestTemplate;
import com.zensar.cms.dto.ResponseTemplate;
import com.zensar.cms.exception.CMSException;
/**
 * @author Grishma Kagde
 *
 * Course Management System manager class.
 */
public interface CourseManagementManager {

	/**
	 * This method create an Instructor Account
	 * @param request
	 * @throws CMSException 
	 * 
	 */
	void createInstructorAccount(RequestTemplate request) throws CMSException;
	
	/**
	 * This method create an Student Account
	 * @param request
	 * @throws CMSException 
	 * 
	 */
	void createStudentAccount(RequestTemplate request) throws CMSException;

	/**
	 * This method create Course
	 * @param request
	 * @throws CMSException 
	 * 
	 */
	void createCourse(RequestTemplate request) throws CMSException;

	/**
	 * This method assign Assignment to the students by the Instructor
	 * @param request
	 * @throws CMSException 
	 * 
	 */
	void assignAssignment(RequestTemplate request) throws CMSException;

	/**
	 * This method assign Grades to the students by the Instructor
	 * @param request
	 * @throws CMSException 
	 * 
	 */
	void assignGrades(RequestTemplate request) throws CMSException;

	/**
	 * This method delete the courses using Course Id
	 * @param courseId, role
	 * @throws CMSException 
	 * 
	 */
	void deleteCourse(Integer courseId, String role) throws CMSException;

	/**
	 * This method return all the Instructors in the User Details DB
	 * @param role
	 * @return ResponseTemplate
	 * @throws CMSException 
	 */
	ResponseTemplate getAllInstructor(String role) throws CMSException;

	/**
	 * This method return all the Students in the User Details DB
	 * @param role
	 * @return ResponseTemplate
	 * @throws CMSException 
	 */
	ResponseTemplate getAllStudents(String role) throws CMSException;

	/**
	 * @param request
	 * @param list of file
	 * @return total Count Integer
	 */
	void uploadAssignment(RequestTemplate request, List<MultipartFile> files);

	/**
	 * This method return all the COurses in the Course DB
	 * @return ResponseTemplate
	 */
	ResponseTemplate getAllCourses();
	

}
