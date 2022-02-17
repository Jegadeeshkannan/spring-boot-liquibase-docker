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

/**
 * @author Jegadeesh
 * This controller provides REST endpoints to save the Suburban details to MySQL DB
 * and retrive the list of Suburban details for the given range of two post codes in an API endpoint
 */
@RestController
@RequestMapping("v1/suburb")
@Slf4j
public class SuburbDetailsController {

    @Autowired
    private SuburbDetailsService suburbDetailsService;

    /**
     * This is the test method, Please ignore this method for this application.
     * @return string
     */
    @GetMapping("test")
    public String test(){
        System.out.println("From Controller");
        return "Jegadeesh";
    }

    /**
     * To Get the suburb names in alphabetical order for giveb post code ranges and get the combined string length of the suburb names
     * @param startPostCode
     * @param endPostCode
     * @return responseDTO (This response dto will have the list of suburban details for given post codes)
     */
    @GetMapping("suburblist/{startPostCode}/{endPostCode}")
    public ResponseEntity<ResponseDTO> getAllSuburbDetails(@PathVariable long startPostCode, @PathVariable long endPostCode) throws Exception{
        List<SuburbDetails> sortListBySuburbName = null;
        /* This below piece of code to retrieve the list of suburban details
            for given two ranges of postcodes. This below line of code to invoke the SuburbanDetailsService.
         */
        List<SuburbDetails>  suburbDetailsList = suburbDetailsService.getAllSuburbsForPostCodeRange(startPostCode,endPostCode);
         sortListBySuburbName = suburbDetailsList.stream()
                .sorted(Comparator.comparing(SuburbDetails::getSuburbName)).collect(Collectors.toList());
        /*
            This below lines of logic to find the total length of the combination
            of all suburban names which we got it from the above lines of code
         */
        int length= sortListBySuburbName.stream().map(SuburbDetails::getSuburbName).collect(Collectors.joining()).length();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSortedListBySuburbNames(sortListBySuburbName);
        responseDTO.setCombinedSuburbNameLength(length);
        if(sortListBySuburbName != null) {
           // log.debug("Suburb Names object length:",sortListBySuburbName.size());
        }
        //log.debug("Combined String length:" , length);
        //ResponseEntity.ok(responseDTO)
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * This below to save the suburban details to MYSQL DB. This below method to invoke the
     * saveSubarbDetails of SubarbDetailsService
     * @param suburbDetailsList
     *
     */
    @PostMapping("suburbDetail")
    public void saveAllSuburbDetails(@RequestBody List<SuburbDetails> suburbDetailsList){
        //log.debug("List:",suburbDetailsList);
        suburbDetailsService.saveSuburbDetails(suburbDetailsList);
        }

}
