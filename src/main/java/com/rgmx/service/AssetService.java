package com.rgmx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgmx.Repository.AssetRepository;
import com.rgmx.entity.Asset;
import com.rgmx.entity.Assignment;
import com.rgmx.entity.Employee;
import com.rgmx.exception.ResourceNotFoundException;
import com.rgmx.model.AssetModel;

@Service
public class AssetService {
	@Autowired
	AssetRepository repository;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	AssignmentService assignmentService;
	
	
	//save asset
	public void saveAsset(AssetModel assetmodel) {
		Asset asset=new Asset(assetmodel.getName(), assetmodel.getDate(), assetmodel.getCondition_note(), assetmodel.getCategory());
		
		   ///////Available id is 1/////
		asset.setAssignment_status(assignmentService.findById(1));
		repository.save(asset);
	}
	
	//list of  all assets
	public List<Asset> asset_list() {
		return repository.findAll();
	}
	
	//search asset based on name
	public List<Asset> findByName(String name) {
		return repository.findByName(name);
	}
	
	//assign asset to emp
	public void assignAsset(Long emp_id,Long asset_id) {
		Employee employee=employeeService.findEmpById(emp_id);
		Asset asset=repository.findById(asset_id).orElseThrow(() -> new ResourceNotFoundException("Asset", "Id", emp_id));
		asset.setEmployee(employee);
		////////assigned id is 2
		asset.setAssignment_status(assignmentService.findById(2));
		repository.save(asset);
	}
	
	
	// deassign asset to emp
	public void deAssignAsset(Long asset_id) {
		Employee employee=null;
		Asset asset=repository.findById(asset_id).orElseThrow(() -> new ResourceNotFoundException("Asset", "Id", asset_id));;
		asset.setEmployee(employee);
		
		//////Recovered id is 3
		asset.setAssignment_status(assignmentService.findById(3));
		repository.save(asset);
	}
	
	
	////////delete the asset//////
	public String delete(Long id) {
		Asset asset= repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asset", "Id", id));
		///////assigned id is 2/////
		if(asset.getAssignment_status().getId()==2) {
			return "Asset is assigned currently cannot be deleted";
		}
		
		repository.deleteById(id);
		
		return "Deleted Succefully";
	}
}
