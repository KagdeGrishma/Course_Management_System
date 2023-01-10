package com.zensar.cms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zensar.cms.dto.CMSRequest;
import com.zensar.cms.dto.CMSResponseTemplate;
import com.zensar.cms.dto.RequestTemplate;
import com.zensar.cms.dto.ResponseTemplate;
import com.zensar.cms.exception.CMSException;
import com.zensar.cms.manager.CourseManagementManager;

@RestController
@RequestMapping("/api/v1")
public class CourseManagementSystemController {
	
	@Autowired
	CourseManagementManager courseManagementManager;

	/*
	@PostMapping(value = "/login/admin", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public  CMSResponseTemplate<ResponseTemplate> createInstructorAccount(@RequestBody CMSRequest<RequestTemplate> request,Locale locale) {
		courseManagementManager.createInstructorAccount(request.getData());
		CMSResponseTemplate<ResponseTemplate> response = new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(), messageSource.getMessage("response.success", null, locale));
		return response;
	}*/
	
	//Method to create Instructor Account by admin
	@PostMapping(value = "/course-management-system/admin/instructor-account", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public  CMSResponseTemplate<ResponseTemplate> createInstructorAccount(@RequestBody CMSRequest<RequestTemplate> request) throws CMSException {
		CMSResponseTemplate<ResponseTemplate> response = null;
		try {
		courseManagementManager.createInstructorAccount(request.getData());
		response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(),"Instructor Account created successfully");
		}catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		}
		
		return response;
	}
	
	//Method to create Student Account by admin
	@PostMapping(value = "/course-management-system/admin/student-account", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public CMSResponseTemplate<ResponseTemplate> createStudentAccount(@RequestBody CMSRequest<RequestTemplate> request) throws CMSException{
		CMSResponseTemplate<ResponseTemplate> response = null;
		try {
		courseManagementManager.createStudentAccount(request.getData());
		response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(),"Student Account created successfully");
		}catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		}
		
		return response;
	}
	
	//Method to create Course by the admin
	@PostMapping(value = "/course-management-system/admin/course", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public CMSResponseTemplate<ResponseTemplate> createCourse(@RequestBody CMSRequest<RequestTemplate> request) {

		CMSResponseTemplate<ResponseTemplate> response = null;
		try {
			courseManagementManager.createCourse(request.getData());
		response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(),"Course created successfully");
		}catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		}
		
		return response;
	}
	
	//Method to assign Assignments to the students by Instructor
	@PostMapping(value = "/course-management-system/instructor/assign-assignment", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public CMSResponseTemplate<ResponseTemplate> assignAssignment(@RequestBody CMSRequest<RequestTemplate> request) {
		
		CMSResponseTemplate<ResponseTemplate> response = null;
		try {
			courseManagementManager.assignAssignment(request.getData());
		response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(),"Instructor successfully assigned the assignment to the student");
		}catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		}
		
		return response;
	}
	
	//Method to assign Assign Grades to the students by Instructor
	@PostMapping(value = "/course-management-system/instructor/assign-grades", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public CMSResponseTemplate<ResponseTemplate> assignGrades(@RequestBody CMSRequest<RequestTemplate> request) {
		
		CMSResponseTemplate<ResponseTemplate> response = null;
		try {
			courseManagementManager.assignGrades(request.getData());
		response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(),"Instructor successfully assigned grades to the student");
		}catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		}
		
		return response;
	}
	
	//Method to view all the Instructor by the admin
	@GetMapping(value = "/course-management-system/admin/all-instructor/{role}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public CMSResponseTemplate<ResponseTemplate> getAllInstructor( @PathVariable(value = "role", required = true)String role) {
		//UserInfo login = authenticationFacade.getPrincipal();
		CMSResponseTemplate<ResponseTemplate> response=null;
		try {
		ResponseTemplate template = courseManagementManager.getAllInstructor(role);
		 response = new CMSResponseTemplate<ResponseTemplate>(template, HttpStatus.OK.value(), "success");
		}
		catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		}
		return response;
		
	}
	
	//Method to view all the students by the admin
	@GetMapping(value = "/course-management-system/admin/all-student/{role}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public CMSResponseTemplate<ResponseTemplate> getAllStudents( @PathVariable(value = "role", required = true)String role) {
		CMSResponseTemplate<ResponseTemplate> response=null;
		try {
		ResponseTemplate template = courseManagementManager.getAllStudents(role);
		 response = new CMSResponseTemplate<ResponseTemplate>(template, HttpStatus.OK.value(), "success");
		}catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		}
		
		return response;
	}
	
	//Method to delete the courses by the admin
	@DeleteMapping(value = "/course-management-system/instructor/{role}/course/{courseId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public CMSResponseTemplate<ResponseTemplate> deleteCourse(@PathVariable(value = "courseId", required = true)Integer courseId, @PathVariable(value = "role", required = true)String role ) {
		CMSResponseTemplate<ResponseTemplate> response =null;
		try {
		courseManagementManager.deleteCourse(courseId,role);
	 response = new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(),"Course deleted successfully");
		}catch(Exception e) {
			if (e instanceof CMSException) {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}else {
				System.out.print(e.getMessage());
				response=new CMSResponseTemplate<ResponseTemplate>(HttpStatus.BAD_REQUEST.value(),e.getMessage());
			}
		
	}
		return response;
	}
	
	//Method to upload the assignment by the student
	@PostMapping(value = "/course-management-system/student/upload-assignment", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE ,MediaType.MULTIPART_FORM_DATA_VALUE })
	public CMSResponseTemplate<ResponseTemplate> uploadAssignment(@RequestBody CMSRequest<RequestTemplate> request,  @RequestPart(value = "files") List<MultipartFile> files)throws MethodArgumentNotValidException {
		courseManagementManager.uploadAssignment(request.getData(),files);
		CMSResponseTemplate<ResponseTemplate> response = new CMSResponseTemplate<ResponseTemplate>(HttpStatus.OK.value(),"success");
		return response;
	}
	//Method to view all the courses by the student
	@GetMapping(value = "/course-management-system/student/all-courses", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public CMSResponseTemplate<ResponseTemplate> getAllCourses() {
		ResponseTemplate template = courseManagementManager.getAllCourses();
		CMSResponseTemplate<ResponseTemplate> response = new CMSResponseTemplate<ResponseTemplate>(template, HttpStatus.OK.value(),"success");
		return response;	
	}
}
