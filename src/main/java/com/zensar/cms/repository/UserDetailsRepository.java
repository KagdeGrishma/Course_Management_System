package com.zensar.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.zensar.cms.model.UserDetails;

/**
 * @author Grishma Kagde
 *
 * Repository for user details table in DB.
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	/**
	 * This method create an Instructor Account
	 * @param role
	 * @return list of {@link UserDetails}
	 */
	List<UserDetails> findByRoleName(String role);
	
	

}
