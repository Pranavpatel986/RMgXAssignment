package com.rgmx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgmx.entity.Asset;
import com.rgmx.entity.Category;
import com.rgmx.entity.Employee;
import com.rgmx.model.AssetModel;
import com.rgmx.model.CategoryModel;
import com.rgmx.model.EmployeeModel;
import com.rgmx.service.AssetService;
import com.rgmx.service.CategoryService;
import com.rgmx.service.EmployeeService;


@RestController
@RequestMapping("/")
public class RmgxController {
	@Autowired
	private AssetService asset_service;
	@Autowired
	private CategoryService category_service;
	@Autowired
	private EmployeeService employeeService;
	
	
	
	/////////get methods///////
	
	
	//////cheak working//////
	@GetMapping
	public String Home() {
		return "Application Started Successfully";
	}
	
	////////list of assets//////////
	@GetMapping("/assets")
	public List<Asset> listAsset() {
		return asset_service.asset_list();
	}
	@GetMapping("/employeed")
	public List<Employee> listEmployees() {
		return employeeService.emp_list();
	}
	
	//////////find asset by name//////////
	@GetMapping("/assets/{name}")
	public List<Asset> searchAssetByName(@PathVariable String name) {
		return asset_service.findByName(name);
	}
	
	
	/////////list of categories////////////
	@GetMapping("/categories")
	public List<Category> listCategories() {
		return category_service.category_list();
	}
	
	////////delete asset/////////
	@GetMapping("/deletecategory/{id}")
	public String deleteAsset(@PathVariable Long id) {
		return asset_service.delete(id);
	}
	
	
	////////post methods///////////
	
	
	
	/////AddAsset with assignment available/////////
	@PostMapping("/asset")
	public void saveAsset(@RequestBody AssetModel assetmodel) {
		asset_service.saveAsset(assetmodel);
	}
	
	
	//////saveEmployee
	@PostMapping("/employee")
	public void saveEmplouee(@RequestBody EmployeeModel employeemodel) {
		employeeService.saveEmp(employeemodel);
	}
	
	
	////saveCategory///////////
	@PostMapping("/category")
	public void saveCategory(@RequestBody CategoryModel categoryModel) {
		category_service.save(categoryModel);
	}
	
	///////assignAsset to emp///////////////
	@PostMapping("/assignAsset/{emp_id}/{asset_id}")
	public void assetAssigntoEmp(@PathVariable Long emp_id,@PathVariable Long asset_id) {
		asset_service.assignAsset(emp_id,asset_id);;
	}
	
	
	//////////recover asset////////////////
	@PostMapping("/deAssignAsset/{asset_id}")
	public void deAssetAssigntoEmp(@PathVariable Long asset_id) {
		asset_service.deAssignAsset(asset_id);;
	}
	
	@PostMapping("/updateCategory")
	public void updateCategory(@RequestBody Category category) {
		category_service.updateCategory(category);
	}
	
}
