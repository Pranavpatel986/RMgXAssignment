package com.rgmx.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import com.rgmx.service.AssignmentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	private String date;
	private String condition_note;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Assignment assignment_status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	
	
	
	public Asset(String name,String date, String condition_note, Category category ) {
		super();
		
		this.name = name;
		this.date = date;
		this.condition_note = condition_note;
		this.category = category;
	}



	  
	

}
