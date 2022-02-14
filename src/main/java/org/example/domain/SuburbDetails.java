package org.example.domain;



import javax.persistence.*;


@Entity
@Table(name="suburb_details",schema = "dev_schema")

public class SuburbDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="suburb_id")
    private int suburbId;

    @Column(name="suburb_name")
    private String suburbName;

    @Column(name="postcode")
    private long postcode;

    public void setSuburbId(int suburbId) {
        this.suburbId = suburbId;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public void setPostcode(long postcode) {
        this.postcode = postcode;
    }

    public int getSuburbId() {
        return suburbId;
    }

    public String getSuburbName() {
        return suburbName;
    }

    @Override
    public String toString() {
        return "SuburbDetails{" +
                "suburbId=" + suburbId +
                ", suburbName='" + suburbName + '\'' +
                ", postcode=" + postcode +
                '}';
    }

    public long getPostcode() {
        return postcode;
    }
}