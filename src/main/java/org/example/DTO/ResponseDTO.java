package org.example.DTO;

import org.example.domain.SuburbDetails;

import java.io.Serializable;
import java.util.List;

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
