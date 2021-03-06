package com.flexionmobile.devtest;

import com.flexionmobile.codingchallenge.integration.Purchase;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * Created by miguel avim on 07/11/2015.
 */
public class BillingIntegrationTest extends TestCase {

    public void testBuy() throws Exception {
        BillingIntegration billingIntegration = new BillingIntegration("avim");
        Purchase purchase = billingIntegration.buy("item123");
        Assert.assertEquals("item123", purchase.getItemId());
    }

    public void testGetPurchases() throws Exception {
        BillingIntegration billingIntegration = new BillingIntegration("avim");
        int sizeBefore = billingIntegration.getPurchases().size();
        billingIntegration.buy("item456");
        List<Purchase> purchaseList = billingIntegration.getPurchases();
        Assert.assertEquals(sizeBefore + 1, purchaseList.size());
    }

    public void testConsume() throws Exception {
        BillingIntegration billingIntegration = new BillingIntegration("avim");
        Purchase purchase = billingIntegration.buy("item789");
        billingIntegration.consume(purchase);
        Assert.assertTrue("Consumed with success - No exception thrown", true);
    }
}