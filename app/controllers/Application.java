package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.compareglobal.service.creditcard.domain.CreditCard;
import play.libs.Json;
import play.mvc.*;

import com.compareglobal.service.creditcard.repository.CreditCardRepo;
import views.html.*;

import java.util.List;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Handa na po."));
    }

    public Result compare() {
        JsonNode json = request().body().asJson();
        ObjectNode result = Json.newObject();
        String locale = json.findPath("locale").asText();

        StringBuilder sbBenefits = new StringBuilder();
        List<CreditCard> creditCardList = CreditCardRepo.getNames("en-HK");
        for (CreditCard creditCard : creditCardList) {
            sbBenefits.append(" Benefits " + creditCard.benefits.size());
            sbBenefits.append(" Criteria " + creditCard.eligibility.size());
            sbBenefits.append(" Fees " + creditCard.fees.size());
            sbBenefits.append(" Promotions " + creditCard.promotions.size());
            sbBenefits.append(" Rewards " + creditCard.rewards.size());
            sbBenefits.append(" General Info " + creditCard.generalInfo.size());
            sbBenefits.append("\n");
        }

        return ok("Credit Card Comparison \n" + locale + sbBenefits.toString());
    }

}
