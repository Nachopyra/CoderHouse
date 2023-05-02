package com.entegable.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BillingDetail implements Serializable {
    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("amount")
    private Integer amount;

    public BillingDetail() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
