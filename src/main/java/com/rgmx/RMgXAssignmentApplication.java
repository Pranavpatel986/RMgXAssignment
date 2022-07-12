package com.rgmx;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.rgmx.entity.Assignment;
import com.rgmx.entity.Category;
import com.rgmx.model.CategoryModel;
import com.rgmx.service.AssignmentService;
import com.rgmx.service.CategoryService;

@SpringBootApplication
public class RMgXAssignmentApplication extends SpringBootServletInitializer{
	
	
	public static void main(String[] args) {
		SpringApplication.run(RMgXAssignmentApplication.class, args);
	}

}
@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CategoryService service;
	@Autowired
	private AssignmentService service2;
	
	
	public void saveCategory() {
		CategoryModel category1=new CategoryModel("Furniture");
		CategoryModel category2=new CategoryModel("Laptop");
		CategoryModel category3=new CategoryModel("KeyBoard");
		CategoryModel category4=new CategoryModel("Stationary");
		service.save(category1);
		service.save(category2);
		service.save(category3);
		service.save(category4);
	}
	public void saveAssignment() {
		Assignment a1=new Assignment(1, "Available");
		Assignment a2=new Assignment(2, "Assigned");
		Assignment a3=new Assignment(3, "Recovered");
		service2.save(a1);
		service2.save(a2);
		service2.save(a3);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		saveAssignment();
		saveCategory();
	}
}

