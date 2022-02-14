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

    public List<SuburbDetails> getAllSuburbsForPostCodeRange(long startPostCode, long endPostCode){
        List<SuburbDetails> suburbDetailsList = suburbRepository.findByPostcodeBetween(startPostCode,endPostCode);
        return suburbDetailsList;
    }

    public void saveSuburbDetails(List<SuburbDetails> suburbDetailsList) {
        suburbRepository.saveAll(suburbDetailsList);
    }
}
