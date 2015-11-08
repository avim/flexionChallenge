package com.flexionmobile.devtest;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;

import java.util.List;

/**
 * Created by miguel avim on 07/11/2015.
 */
public class BillingIntegration implements Integration {

    private String developerId;
    private RestAPIService restAPIService;

    public BillingIntegration() {
        restAPIService = new RestAPIService();
    }

    public BillingIntegration(String developerId) {
        this();
        this.developerId = developerId;
    }

    /**
     * @param itemId
     * @return
     */
    public Purchase buy(String itemId) {
        return restAPIService.buy(itemId, developerId);
    }

    /**
     * @return
     */
    public List<Purchase> getPurchases() {
        return restAPIService.getPurchases(developerId);
    }

    /**
     * @param purchase
     */
    public void consume(Purchase purchase) {
        restAPIService.consume(purchase.getId(), developerId);
    }
}
