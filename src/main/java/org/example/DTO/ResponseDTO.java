package org.example.DTO;

import org.example.domain.SuburbDetails;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jegadeesh
 * This is the Data Transfer Object to share the JSON data to the requestor
 * (This case Postman tool or any front end application).
 * This will hold the data for the list of Suburb Details of given range of post codes and
 * it will hold the length of the combined string of the suburban names of the given range of postcodes.
 */

public class ResponseDTO implements Serializable {

    public List<SuburbDetails> sortedListBySuburbNames;
    public int combinedSuburbNameLength;

    public List<SuburbDetails> getSortedListBySuburbNames() {
        return sortedListBySuburbNames;
    }

    public void setSortedListBySuburbNames(List<SuburbDetails> sortedListBySuburbNames) {
        this.sortedListBySuburbNames = sortedListBySuburbNames;
    }

    public int getCombinedSuburbNameLength() {
        return combinedSuburbNameLength;
    }

    public void setCombinedSuburbNameLength(int combinedSuburbNameLength) {
        this.combinedSuburbNameLength = combinedSuburbNameLength;
    }
}
