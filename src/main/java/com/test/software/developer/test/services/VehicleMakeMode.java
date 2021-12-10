/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.services;

import com.test.software.developer.test.model.Asset;
import com.test.software.developer.test.repository.AssetRepository;
import com.test.software.developer.test.repository.VehicleMakeRepository;
import com.test.software.developer.test.repository.VehicleModelRepository;
import com.test.software.developer.test.service.LoansService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import static org.hibernate.bytecode.BytecodeLogging.LOGGER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author collins
 */
@Service
public class VehicleMakeMode {
    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleMakeMode.class);

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    VehicleModelRepository vehicleModelRepository;

    public List<Long> allAsset() {
        LOGGER.info("******Populating Number of car assets");
        List<Long> modelList = new ArrayList<>();
        List<Asset> assetList = assetRepository.findAll();
        for (int i = 0; i < assetList.size(); i++) {
            modelList.add(assetList.get(i).getModelId().getId());

        }
        return modelList;
    }

    public HashMap<String, Integer> vehicleModelCount() {
        LOGGER.info("calculating number of make from the number of model");
        HashMap<String, Integer> vehicleMap = new HashMap<>();

        List<Long> vehicleModel = allAsset();
        for (int i = 0; i < vehicleModel.size(); i++) {
            Long modelId = vehicleModel.get(i);
            String vehicleName = vehicleModelRepository.findById(modelId).get().getVehicleMakeId().getName();
            int count = 0;
            if (!vehicleMap.containsKey(vehicleName)) {
                for (int j = 0; j < vehicleModel.size(); j++) {
                    if (vehicleModel.get(i).equals(vehicleModel.get(j))) count++;
                    
                }
                vehicleMap.put(vehicleName, count);

            }
            LOGGER.info("+++++ "+vehicleModel.get(i)+" ++++++");

        }
        
         
         
         

        return vehicleMap;

    }

}
