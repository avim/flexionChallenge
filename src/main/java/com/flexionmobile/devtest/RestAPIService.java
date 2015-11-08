package com.flexionmobile.devtest;

import com.flexionmobile.codingchallenge.integration.Purchase;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by miguel avim on 07/11/2015.
 */
public class RestAPIService {

    private static final String BASE_URL = "http://dev2.flexionmobile.com/javachallenge/rest/developer/";

    private Client client;

    public RestAPIService() {
        client = ClientBuilder.newClient();
    }

    /**
     * Buy Item
     * Call this method to buy one item. Items can be bought multiple times
     *
     * @param itemId
     * @param developerId
     * @return Purchase
     */
    public Purchase buy(String itemId, String developerId) {
        WebTarget target = this.client.target(BASE_URL)
                .path(developerId)
                .path("buy")
                .path(itemId);

        Response response = target.request().post(Entity.entity(null, MediaType.APPLICATION_JSON));
        if (response.getStatus() != 200) {
            throw new RuntimeException("Error occurred on server: " + response.getStatus());
        }
        return response.readEntity(PurchaseImpl.class);
    }

    /**
     * Get All Purchases
     * Call this method to retrieve all previous purchases
     *
     * @param developerId
     * @return List<Purchase>
     */
    public List<Purchase> getPurchases(String developerId) {
        List purchases = new ArrayList();
        WebTarget target = this.client.target(BASE_URL)
                .path(developerId)
                .path("all");

        Response response = target.request().get(Response.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Error occurred on server: " + response.getStatus());
        }

        // TODO Avim: Check if there are a simpler way of doing this
        JSONObject obj = new JSONObject(response.readEntity(String.class));
        JSONArray array = obj.getJSONArray("purchases");
        for (int i = 0; i < array.length(); i++) {
            purchases.add(new PurchaseImpl(
                            array.getJSONObject(i).getString("id"),
                            Boolean.parseBoolean(array.getJSONObject(i).getString("consumed")),
                            array.getJSONObject(i).getString("itemId"))
            );
        }

        return purchases;
    }

    /**
     * Consume purchase
     * Call this method to consume one purchase.
     *
     * @param purchaseId
     * @param developerId
     */
    public void consume(String purchaseId, String developerId) {
        WebTarget target = this.client.target(BASE_URL)
                .path(developerId)
                .path("consume")
                .path(purchaseId);

        Response response = target.request().post(Entity.entity(null, MediaType.APPLICATION_JSON));
        if (response.getStatus() != 200) {
            throw new RuntimeException("Error occurred on server: " + response.getStatus());
        }
    }
}
