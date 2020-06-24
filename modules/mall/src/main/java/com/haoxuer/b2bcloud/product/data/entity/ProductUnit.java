package com.haoxuer.b2bcloud.product.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public interface ProductUnit extends Serializable {
    boolean getIsSku();

    Integer getId();

    boolean getVirtual();

    BigDecimal getForSalePrice();

    Double getWeight();

    Product getProduct();

    Integer getProductId();

    Integer getInventory();

    Integer getStoreId();
}
