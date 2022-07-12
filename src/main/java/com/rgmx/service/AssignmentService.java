package com.rgmx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgmx.Repository.AssignmentRepository;
import com.rgmx.entity.Assignment;
import com.rgmx.exception.ResourceNotFoundException;

@Service
public class AssignmentService {
	@Autowired
	AssignmentRepository assignmentRepository;
	
	public void save(Assignment assignment) {
		assignmentRepository.save(assignment);
	}

	public Assignment findById(int id) {
		Assignment assignment=assignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assignment", "Id", id));;
		return assignment;
	}
}