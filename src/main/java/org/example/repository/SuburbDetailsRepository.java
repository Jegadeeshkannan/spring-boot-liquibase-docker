package org.example.repository;


import org.example.domain.SuburbDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This is the Spring Data JPA repository which extends the JPARepository which will do the database operation like
 * save the suburb details data, retrieve the suburb details and
 * it will generate the custom queries for Spring Data JPA methods (ex. findByPostcodeBetween)
 */

public interface SuburbDetailsRepository extends JpaRepository<SuburbDetails, Long> {
    // This method returns the list of suburban details for two range of postcodes (startpostcoe and endpostcode))
    public List<SuburbDetails> findByPostcodeBetween(long startPostCode , long endPostCode);
}
