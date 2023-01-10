package com.zensar.cms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Grishma Kagde
 *
 * Course Management System RequestTemplate dto class.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTemplate {
	
	private UserDetailsInfo userDetailsInfo;

	private CourseInfo courseInfo;
	
	private AssignmentInfo assignmentInfo;
	
	
	public UserDetailsInfo getUserDetailsInfo() {
		return userDetailsInfo;
	}

	public void setUserDetailsInfo(UserDetailsInfo userDetailsInfo) {
		this.userDetailsInfo = userDetailsInfo;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public AssignmentInfo getAssignmentInfo() {
		return assignmentInfo;
	}

	public void setAssignmentInfo(AssignmentInfo assignmentInfo) {
		this.assignmentInfo = assignmentInfo;
	}
	

}
