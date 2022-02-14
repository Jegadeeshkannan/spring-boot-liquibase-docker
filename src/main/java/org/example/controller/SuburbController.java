package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.DTO.ResponseDTO;
import org.example.domain.SuburbDetails;
import org.example.service.SuburbDetailsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/suburb")
@Slf4j
public class SuburbController {

    @Autowired
    private SuburbDetailsService suburbDetailsService;

    @GetMapping("test")
    public String test(){
        System.out.println("From Controller");
        return "Jegadeesh";
    }

    /**
     * To Get the suburb names in alphabetical order for giveb post code ranges and get the combined string length of the suburb names
     * @param startPostCode
     * @param endPostCode
     * @return
     */
    @GetMapping("suburblist/{startPostCode}/{endPostCode}")
    public ResponseEntity<ResponseDTO> getAllSuburbDetails(@PathVariable long startPostCode, @PathVariable long endPostCode){
        List<SuburbDetails> sortListBySuburbName = null;
        List<SuburbDetails>  suburbDetailsList = suburbDetailsService.getAllSuburbsForPostCodeRange(startPostCode,endPostCode);
         sortListBySuburbName = suburbDetailsList.stream()
                .sorted(Comparator.comparing(SuburbDetails::getSuburbName)).collect(Collectors.toList());
        int length= sortListBySuburbName.stream().map(SuburbDetails::getSuburbName).collect(Collectors.joining()).length();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSortedListBySuburbNames(sortListBySuburbName);
        responseDTO.setCombinedSuburbNameLength(length);
        if(sortListBySuburbName != null) {
           // log.debug("Suburb Names object length:",sortListBySuburbName.size());
        }
        //log.debug("Combined String length:" , length);
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * To save the Suburb details to MYSQL DB
     * @param suburbDetailsList
     */
    @PostMapping("suburbDetail")
    public void saveAllSuburbDetails(@RequestBody List<SuburbDetails> suburbDetailsList){
        //log.debug("List:",suburbDetailsList);
        suburbDetailsService.saveSuburbDetails(suburbDetailsList);
        }

}
