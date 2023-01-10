package com.zensar.cms.util;

/**
 * @author Grishma Kagde
 *
 * Course Manangement System Constant class
 */
public class Constants {
	
	public enum Role {
		INSTRUCTOR("INSTRUCTOR"), STUDENT("STUDENT"), ADMIN("ADMIN");

		private Role(String role) {
			this.role = role;
		}

		private final String role;

		public String getRole() {
			return role;
		}
	}
	
	public enum Status {
		ACTIVE("ACTIVE"), DEACTIVE("DEACTIVE");

		private Status(String status) {
			this.status = status;
		}

		private final String status;

		public String getStatus() {
			return status;
		}
	}
	
	public enum Grades {
		A("A"), B("B"), C("C"), D("D"), E("E"),F("F");

		private Grades(String grades) {
			this.grades = grades;
		}

		private final String grades;

		public String getGrades() {
			return grades;
		}
	}
}
