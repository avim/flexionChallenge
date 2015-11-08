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
     * Buy Item
     * Call this method to buy one item. Items can be bought multiple times
     *
     * @param itemId
     * @return Purchase
     */
    public Purchase buy(String itemId) {
        return restAPIService.buy(itemId, developerId);
    }

    /**
     * Get All Purchases
     * Call this method to retrieve all previous purchases
     *
     * @return List<Purchase>
     */
    public List<Purchase> getPurchases() {
        return restAPIService.getPurchases(developerId);
    }

    /**
     * Consume purchase
     * Call this method to consume one purchase.
     *
     * @param purchase
     */
    public void consume(Purchase purchase) {
        restAPIService.consume(purchase.getId(), developerId);
    }
}
