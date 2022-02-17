package org.example.service;

import org.example.domain.SuburbDetails;
import org.example.repository.SuburbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuburbDetailsService {
    @Autowired
    private SuburbRepository suburbRepository;

    /**
     *
     * @param startPostCode
     * @param endPostCode
     * @return
     */
    public List<SuburbDetails> getAllSuburbsForPostCodeRange(long startPostCode, long endPostCode){
        List<SuburbDetails> suburbDetailsList = suburbRepository.findByPostcodeBetween(startPostCode,endPostCode);
        return suburbDetailsList;
    }

    /**
     *
     * @param suburbDetailsList
     */
    public void saveSuburbDetails(List<SuburbDetails> suburbDetailsList) {
        suburbRepository.saveAll(suburbDetailsList);
    }
}
