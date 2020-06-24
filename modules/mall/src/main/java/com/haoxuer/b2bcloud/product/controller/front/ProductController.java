package com.haoxuer.b2bcloud.product.controller.front;

import com.haoxuer.b2bcloud.product.data.entity.Product;
import com.haoxuer.b2bcloud.product.data.service.ProductService;
import com.haoxuer.b2bcloud.product.data.so.ProductSo;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("testIn")
    @ResponseBody
    public String testIn() {
        Pageable pageable = new Pageable();
        ProductSo so = new ProductSo();
        List<Integer> catalogs = new ArrayList<>();
        catalogs.add(2);
        catalogs.add(3);
        so.setCatalogs(null);
        List<Long> tags=new ArrayList<>();
        tags.add(1L);
        Page<Product> page = productService.page(pageable, so,tags);
        List<Product> products = page.getContent();
        for (Product product : products) {
            System.out.println(product.getId());
        }
        return "ok";
    }
}
