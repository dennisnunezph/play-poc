package com.compareglobal.service.creditcard.domain;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    private Integer minimum;

    private Integer maximum;

    private String description;

    private String additionalInfo;
    private Integer typeKey;
    private String typeValue;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="creditcard_id")
    private CreditCard creditcard;

    public String getDescription() {
        return description;
    }

    public Integer getMinimum() { return minimum; }

    public Integer getMaximum() {
        return maximum;
    }

    public Integer getTypeKey() { return typeKey; }

    public String getTypeValue() { return typeValue; }
}
