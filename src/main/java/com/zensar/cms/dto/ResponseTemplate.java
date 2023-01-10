package com.zensar.cms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Grishma Kagde
 *
 * Course Management System ResponseTemplate dto class.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseTemplate {
private List<UserDetailsInfo> userDetailsInfo;

private List<CourseInfo> courseInfo;

public List<UserDetailsInfo> getUserDetailsInfo() {
	return userDetailsInfo;
}

public void setUserDetailsInfo(List<UserDetailsInfo> userDetailsInfo) {
	this.userDetailsInfo = userDetailsInfo;
}

public List<CourseInfo> getCourseInfo() {
	return courseInfo;
}

public void setCourseInfo(List<CourseInfo> courseInfo) {
	this.courseInfo = courseInfo;
}


}
