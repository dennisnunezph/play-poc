package com.compareglobal.service.creditcard.domain;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     */
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("99999.99")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal amount;

    /**
     */
    @Size(max = 1000)
    private String description;

    /**
     */
    @Size(max = 1000)
    private String additionalInfo;
    private Integer typeKey;
    private String typeValue;

    /**
     */
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="creditcard_id")
    private CreditCard creditcard;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public Integer getTypeKey() { return typeKey; }
}
