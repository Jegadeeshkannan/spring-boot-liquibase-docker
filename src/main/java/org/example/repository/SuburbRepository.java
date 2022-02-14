package org.example.repository;


import org.example.domain.SuburbDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SuburbRepository extends JpaRepository<SuburbDetails, Long> {

    public List<SuburbDetails> findByPostcodeBetween(long startPostCode , long endPostCode);
}
