package com.compareglobal.service.creditcard.domain;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Long getId() {
        return id;
    }

    public Integer getTypeKey() { return typeKey; }

    public String getTypeValue() { return typeValue; }
}
