package com.compareglobal.service.creditcard.domain;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

/**
 * Created by dennis on 7/3/15.
 */
@Entity
public class CreditCard extends Model {

    @Id
    public Long id;

    public String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="creditcard_id")
    public Set<Benefit> benefits = new HashSet<Benefit>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    public Set<Criteria> eligibility = new HashSet<Criteria>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    public Set<Fee> fees = new HashSet<Fee>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    public Set<Promotion> promotions = new HashSet<Promotion>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    public Set<Reward> rewards = new HashSet<Reward>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "creditcard")
    public Set<GeneralInfo> generalInfo = new HashSet<GeneralInfo>();

    public static Finder<Long, CreditCard> find
            = new Model.Finder<>(Long.class, CreditCard.class);

}
