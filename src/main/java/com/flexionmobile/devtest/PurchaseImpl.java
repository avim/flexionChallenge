package com.flexionmobile.devtest;

import com.flexionmobile.codingchallenge.integration.Purchase;

/**
 * Created by miguel avim on 07/11/2015.
 */
public class PurchaseImpl implements Purchase {

    private boolean consumed;
    private String id;
    private String itemId;

    public PurchaseImpl(String id, boolean consumed, String itemId) {
        this.consumed = consumed;
        this.id = id;
        this.itemId = itemId;
    }

    public PurchaseImpl() {
    }

    public String getId() {
        return id;
    }

    public boolean getConsumed() {
        return consumed;
    }

    public String getItemId() {
        return itemId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }
}
