package com.haoxuer.b2bcloud.product.api.apis;


import com.haoxuer.b2bcloud.product.api.domain.list.ProductCatalogList;
import com.haoxuer.b2bcloud.product.api.domain.page.ProductCatalogPage;
import com.haoxuer.b2bcloud.product.api.domain.request.*;
import com.haoxuer.b2bcloud.product.api.domain.response.ProductCatalogResponse;
import com.haoxuer.bigworld.member.api.domain.request.ViewRequest;

public interface ProductCatalogApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    ProductCatalogResponse create(ProductCatalogCreateRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    ProductCatalogResponse update(ProductCatalogUpdateRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    ProductCatalogResponse delete(ProductCatalogDeleteRequest request);



    /**
     *
     * @param request
     * @return
     */
    ProductCatalogList list(ProductCatalogListRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    ProductCatalogPage search(ProductCatalogSearchRequest request);

}