package com.entegable.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class BillingRequest implements Serializable {
    @JsonProperty("client_id")
    private Long clientId;
    @JsonProperty("billing_detail")
    private List<BillingDetail> billingDetails;

    public BillingRequest() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<BillingDetail> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(List<BillingDetail> billingDetails) {
        this.billingDetails = billingDetails;
    }
}



