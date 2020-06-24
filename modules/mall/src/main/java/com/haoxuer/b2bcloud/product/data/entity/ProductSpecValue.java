package com.haoxuer.b2bcloud.product.data.entity;

import com.haoxuer.bigworld.tenant.data.entity.TenantEntity;
import com.haoxuer.discover.data.annotations.FormAnnotation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@FormAnnotation(title = "商品信息", add = "商品信息", list = "商品信息", update = "商品信息")
@Entity
@Table(name = "bs_tenant_product_spec_value")
public class ProductSpecValue extends TenantEntity implements Comparable{

    private String name;

    /** 图片 */
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSpec spec;

    private Integer sortNum;

    @Override
    public int compareTo(Object o) {
        ProductSpecValue item=(ProductSpecValue)o;
        if ( this.sortNum==null){
            this.sortNum=0;
        }
        if (item.sortNum==null){
            item.sortNum=0;
        }
        return compare(this.sortNum,item.sortNum);
    }

    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
