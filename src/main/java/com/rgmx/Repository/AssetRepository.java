package com.rgmx.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgmx.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long>{
	public List<Asset> findByName(String name);
}
