package com.compareglobal.service.creditcard.repository;


import java.util.*;
import javax.persistence.*;

import com.compareglobal.service.creditcard.domain.CreditCard;
import play.db.ebean.*;

/**
 * Created by dennis on 7/3/15.
 */
public class CreditCardRepo {


    public static List<CreditCard> getNames(String locale) {
        return CreditCard.find.all();
    }
}
