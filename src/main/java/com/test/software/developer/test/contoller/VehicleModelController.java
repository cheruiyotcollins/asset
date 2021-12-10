/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.contoller;

import com.test.software.developer.test.model.Asset;
import com.test.software.developer.test.model.VehicleModel;
import com.test.software.developer.test.repository.AssetRepository;
import com.test.software.developer.test.repository.VehicleModelRepository;
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
@RequestMapping(value = "/model", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleModelController {
     @Autowired
    VehicleModelRepository vehicleModelRepository;

    @GetMapping("view/{id}")
    public VehicleModel viewLoan(@PathVariable long id) {
        return vehicleModelRepository.getById(id);
    }

    @GetMapping("/list")
    public List<VehicleModel> list() {

        return new LinkedList<VehicleModel>(vehicleModelRepository.findAll());

    }
}
