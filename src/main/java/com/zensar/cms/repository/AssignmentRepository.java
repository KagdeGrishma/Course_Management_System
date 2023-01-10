package com.zensar.cms.repository;

/**
 * @author Grishma Kagde
 *
 * Repository for assignment table in DB.
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.cms.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

}
