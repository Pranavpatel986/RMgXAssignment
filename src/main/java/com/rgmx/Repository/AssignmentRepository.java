package com.rgmx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgmx.entity.Assignment;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{
}
