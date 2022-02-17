package org.example.service;

import org.example.domain.SuburbDetails;
import org.example.repository.SuburbDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This the Service component for this application.
 * The methods available in the class will make the repository call to do the crud operations.
 */
@Service
public class SuburbDetailsService {
    @Autowired
    private SuburbDetailsRepository suburbDetailsRepository;

    /**
     * This method will receive the two postcode as parameters to fetch the list of suburban details for given postcodes
     * @param startPostCode
     * @param endPostCode
     * @return
     */
    public List<SuburbDetails> getAllSuburbsForPostCodeRange(long startPostCode, long endPostCode){
        List<SuburbDetails> suburbDetailsList = suburbDetailsRepository.findByPostcodeBetween(startPostCode,endPostCode);
        return suburbDetailsList;
    }

    /**
     * This service method will save the suburban details data to DB using the SuburbanRepository component saveALL meythod.
     * This method will save the one or many suburban details data to MySQL database
     * @param suburbDetailsList
     */
    public void saveSuburbDetails(List<SuburbDetails> suburbDetailsList) {
        suburbDetailsRepository.saveAll(suburbDetailsList);
    }
}
