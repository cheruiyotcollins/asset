/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.contoller;

import com.test.software.developer.test.model.Asset;
import com.test.software.developer.test.repository.AssetRepository;
import com.test.software.developer.test.services.VehicleMakeMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author collins
 */
@RestController
@RequestMapping(value = "/asset", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssetController {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    VehicleMakeMode vehicleMakeMode;

    @GetMapping("view/{id}")
    public Asset viewLoan(@PathVariable long id) {
        return assetRepository.getById(id);
    }

    @GetMapping("/list")
    public List<Asset> list() {

        return new LinkedList<Asset>(assetRepository.findAll());

    }

    @GetMapping("/sold")
    public HashMap<String, Integer> vehicleSold() {
    return vehicleMakeMode.vehicleModelCount();
        
    }
}
