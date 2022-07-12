package com.rgmx.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.rgmx.entity.Assignment;
import com.rgmx.entity.Category;
import com.rgmx.service.AssetService;
import com.rgmx.service.AssignmentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AssetModel {
	
	@Autowired
	AssignmentService service;
	
	private String name;
	private String date;
	private String condition_note;
	private Category category;
	private Assignment assignment_status;
	public AssetModel(String name, String condition_note, Category category) {
		super();
		this.name = name;
		this.condition_note = condition_note;
		this.category = category;
		this.assignment_status = service.findById(1);
		this.date=java.time.LocalDate.now().toString();
	}
	
	
}
