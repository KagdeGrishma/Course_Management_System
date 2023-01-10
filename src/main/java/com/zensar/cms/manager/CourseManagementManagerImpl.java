package com.zensar.cms.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zensar.cms.dto.CourseInfo;
import com.zensar.cms.dto.RequestTemplate;
import com.zensar.cms.dto.ResponseTemplate;
import com.zensar.cms.dto.UserDetailsInfo;
import com.zensar.cms.exception.CMSException;
import com.zensar.cms.model.Assignment;
import com.zensar.cms.model.Course;
import com.zensar.cms.model.UserDetails;
import com.zensar.cms.model.Validator;
import com.zensar.cms.repository.AssignmentRepository;
import com.zensar.cms.repository.CourseRepository;
import com.zensar.cms.repository.UserDetailsRepository;
import com.zensar.cms.util.Constants;

@Service("courseManagementManager")
public class CourseManagementManagerImpl implements CourseManagementManager {

	private Logger logger=LoggerFactory.getLogger(CourseManagementManagerImpl.class);
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	AssignmentRepository assignmentRepository;

	
	  @Value("${org.connect.image.source.url}") private String imageSourceUrl;
	  
	  @Value("${org.connect.image.download.url}") private String imageDownloadUrl;
	 

	@Override
	public void createInstructorAccount(RequestTemplate request) throws CMSException{
		UserDetails userDetails = new UserDetails();
		Validator validate =new Validator();
		
			String message=validate.isValid(request);
		if(message.equalsIgnoreCase("Valid")) {
			if(request.getUserDetailsInfo().getRole().equalsIgnoreCase(Constants.Role.ADMIN.getRole())) {
				
			
			userDetails.setAddress(request.getUserDetailsInfo().getAddress());
			if(Objects.nonNull(request.getUserDetailsInfo().getFirstname())) {
			userDetails.setFirstname(request.getUserDetailsInfo().getFirstname());}
			userDetails.setLastname(request.getUserDetailsInfo().getLastname());
			userDetails.setMobileNumber(request.getUserDetailsInfo().getMobileNumber());
			userDetails.setPassword(request.getUserDetailsInfo().getPassword());
			userDetails.setRoleName(Constants.Role.INSTRUCTOR.getRole());
			userDetails.setUsername(request.getUserDetailsInfo().getUsername());
			userDetails.setCreatedBy(request.getUserDetailsInfo().getCreatedBy());
			userDetails.setCreatedTime(LocalDateTime.now());
			userDetailsRepository.save(userDetails);
		}
		else {
			throw new CMSException("Only Admin can create an account");
		}
			}else {
				throw new CMSException(message);
			}
		
	}

	@Override
	public void createStudentAccount(RequestTemplate request) throws CMSException{
			UserDetails userDetails = new UserDetails();
			Validator validate =new Validator();
			
				String message=validate.isValid(request);
			if(message.equalsIgnoreCase("Valid")) {
				if(request.getUserDetailsInfo().getRole().equalsIgnoreCase(Constants.Role.ADMIN.getRole())) {
			userDetails.setAddress(request.getUserDetailsInfo().getAddress());
			userDetails.setFirstname(request.getUserDetailsInfo().getFirstname());
			userDetails.setLastname(request.getUserDetailsInfo().getLastname());
			userDetails.setMobileNumber(request.getUserDetailsInfo().getMobileNumber());
			userDetails.setPassword(request.getUserDetailsInfo().getPassword());
			userDetails.setRoleName(Constants.Role.STUDENT.getRole());
			userDetails.setUsername(request.getUserDetailsInfo().getUsername());
			userDetails.setCreatedBy(request.getUserDetailsInfo().getCreatedBy());
			userDetails.setCreatedTime(LocalDateTime.now());
			userDetailsRepository.save(userDetails);
		}
		else {
			throw new CMSException("Only Admin can create an account");
		}
			}else {
				throw new CMSException(message);
			}
		
	}

	@Override
	public void createCourse(RequestTemplate request) throws CMSException{
		if(request.getCourseInfo().getRole().equalsIgnoreCase(Constants.Role.ADMIN.getRole())) {
			Course course = new Course();
			course.setCourseName(request.getCourseInfo().getCourseName());
			course.setActive(Constants.Status.ACTIVE.getStatus());
			course.setCreatedBy(request.getCourseInfo().getCreatedBy());
			course.setCreatedTime(LocalDateTime.now());
			courseRepository.save(course);
		}else {
			throw new CMSException("Only Admin can create an account");
		}
		}
	

	@Override
	public void assignAssignment(RequestTemplate request) throws CMSException {
		if(request.getCourseInfo().getRole().equalsIgnoreCase(Constants.Role.INSTRUCTOR.getRole())) {
		Assignment assignment = new Assignment();
		if(Objects.nonNull(request)){
		assignment.setAssociateId(request.getAssignmentInfo().getAssociateId());
		assignment.setCourseId(request.getAssignmentInfo().getCourseId());
		assignment.setDescription(request.getAssignmentInfo().getDescription());
		assignment.setCreatedBy(request.getAssignmentInfo().getCreatedBy());
		assignment.setRoleName(Constants.Role.INSTRUCTOR.getRole());
		assignmentRepository.save(assignment);
		 }
		}
		else {
			throw new CMSException("Only Instructor can assign Assignment");
		}
	}

	@Override
	public void assignGrades(RequestTemplate request) throws CMSException {
		if(request.getCourseInfo().getRole().equalsIgnoreCase(Constants.Role.INSTRUCTOR.getRole())) {
		Assignment assignment = new Assignment();
		if(Objects.nonNull(request)){
		assignment.setAssociateId(request.getAssignmentInfo().getAssociateId());
		assignment.setCourseId(request.getAssignmentInfo().getCourseId());
		assignment.setCreatedBy(request.getAssignmentInfo().getCreatedBy());
		assignment.setMarks(request.getAssignmentInfo().getMarks());
		double percentage = percentage(request.getAssignmentInfo().getMarks());
		assignment.setPercentage(percentage);
		if (percentage >= 0 && percentage <= 50)
			assignment.setGrades(Constants.Grades.F.getGrades());
		else if (percentage >= 50 && percentage <= 60)
			assignment.setGrades(Constants.Grades.E.getGrades());
		else if (percentage >= 60 && percentage <= 70)
			assignment.setGrades(Constants.Grades.D.getGrades());
		else if (percentage >= 70 && percentage <= 80)
			assignment.setGrades(Constants.Grades.C.getGrades());
		else if (percentage >= 80 && percentage <= 90)
			assignment.setGrades(Constants.Grades.B.getGrades());
		else if (percentage >= 90 && percentage <= 100)
			assignment.setGrades(Constants.Grades.A.getGrades());
		assignment.setRoleName(Constants.Role.INSTRUCTOR.getRole());
		}
		assignmentRepository.save(assignment);
		}
		else {
			throw new CMSException("Only Instructor can assign grades");
		}
	}

	private double percentage(double marks) {
		
		double percentage = marks * 100 / 100;
		return percentage;
		
	}

	@Override
	public void deleteCourse(Integer courseId, String role) throws CMSException {
		if(role.equalsIgnoreCase(Constants.Role.INSTRUCTOR.getRole())) {
		Course course=courseRepository.findByCourseId(courseId);
		if(Objects.nonNull(course)) {
			course.setActive(Constants.Status.DEACTIVE.getStatus());
		}
		}
		else {
			throw new CMSException("Only Admin can delete courses");
		}
	}

	@Override
	public ResponseTemplate getAllInstructor(String role) throws CMSException {
		ResponseTemplate response = new ResponseTemplate();
		List<UserDetailsInfo> userDetailsInfos = new ArrayList<UserDetailsInfo>();
		if(role.equalsIgnoreCase(Constants.Role.ADMIN.getRole())) {
		List<UserDetails> userDetails = userDetailsRepository.findByRoleName(Constants.Role.INSTRUCTOR.getRole());
		if(Objects.nonNull(userDetails)) {
		userDetails.forEach(userDetail -> {
			UserDetailsInfo userDetailsInfo = new UserDetailsInfo(userDetail);
			userDetailsInfos.add(userDetailsInfo);
		});		
		response.setUserDetailsInfo(userDetailsInfos);
		}
		return response;
		}
		else
		{
			throw new CMSException("Only Admin can view the list of Students");
		}
		
	}

	@Override
	public ResponseTemplate getAllStudents(String role ) throws CMSException {
		ResponseTemplate response = new ResponseTemplate();
		List<UserDetailsInfo> userDetailsInfos = new ArrayList<UserDetailsInfo>();
		if(role.equalsIgnoreCase(Constants.Role.ADMIN.getRole())) {
		List<UserDetails> userDetails = userDetailsRepository.findByRoleName(Constants.Role.STUDENT.getRole());
		if(userDetails.isEmpty()) {
		userDetails.forEach(userDetail -> {
			UserDetailsInfo userDetailsInfo = new UserDetailsInfo(userDetail);
			userDetailsInfos.add(userDetailsInfo);
		});
		}
		response.setUserDetailsInfo(userDetailsInfos);
		return response;
		}
		else
		{
			throw new CMSException("Only Admin can view the list of Students");
		}
	}

	@Override
	public void uploadAssignment(RequestTemplate request, List<MultipartFile> files) {
		/*
		 * if(Objects.nonNull(request)) { Assignment assignment = new Assignment();
		 * assignment.setAssociateId(request.getAssignmentInfo().getAssociateId());
		 * assignment.setCourseId(request.getAssignmentInfo().getCourseId());
		 * assignment.setCreatedBy(request.getAssignmentInfo().getCreatedBy());
		 * assignment.setRoleName(Constants.Role.STUDENT.getRole()); files.forEach(file
		 * -> { try { FileUtility.saveFile(file, imageSourceUrl); String fileDownloadUri
		 * = imageDownloadUrl + file.getOriginalFilename();
		 * assignment.setUpload_assignment(fileDownloadUri); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * });
		 * 
		 * assignmentRepository.save(assignment);
		 */		}

	

	@Override
	public ResponseTemplate getAllCourses() {
		List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
		List<Course> courses = courseRepository.findByActive(Constants.Status.ACTIVE.getStatus());
		if(courses.isEmpty()) {
			
			logger.info("There are no available courses in the db");
}
		else
			courses.forEach(course -> {
				CourseInfo courseInfo = new CourseInfo(course);
				courseInfos.add(courseInfo);
			});
			ResponseTemplate response = new ResponseTemplate();
			response.setCourseInfo(courseInfos);
			return response;
		}
}
