package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.discover.data.entity.LongEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "bs_product_price")
public class ProductPrice extends LongEntity {

  //20190502
  @Column(name = "data_key",length = 10)
  private String key;

  private BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  private Product product;

  private Date addDate;

}
