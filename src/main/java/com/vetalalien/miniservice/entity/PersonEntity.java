package com.vetalalien.miniservice.entity;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "person")
/*
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "ProductEntityWithOption",
                attributeNodes = {
                        @NamedAttributeNode(value = "options")
                }),
        @NamedEntityGraph(
                name = "ProductEntityFull",
                attributeNodes = {
                        @NamedAttributeNode(value = "options"),
                        @NamedAttributeNode(value = "borrowerReqs"),
                        @NamedAttributeNode(value = "realtyObjectReqs"),
                        @NamedAttributeNode(value = "changeablePercentageRate")
                })
})
*/

public class PersonEntity extends NamedEntityWithLongId {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    /*
    @ManyToOne
    private PersonEntity firstRelease;
    /*
/*
    @ManyToMany
    @JoinTable(name = "product_option",
            joinColumns =
            @JoinColumn(name = "parent_id", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "option_id", referencedColumnName = "ID")
    )
    private Set<ProductEntity> options;
*/

/*
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private ProductChangeablePercentageRateEntity changeablePercentageRate;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private BorrowerReqsEntity borrowerReqs;
*/
/*
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "product_region_mortgage", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    @Column(name = "region")
    private Set<String> mortgageRegions;
*/


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

}
