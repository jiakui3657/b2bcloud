package com.haoxuer.b2bcloud.promote.api.domain.response;


import com.haoxuer.discover.rest.base.ResponseObject;
import lombok.Data;

/**
*
* Created by imake on 2020年05月11日14:14:40.
*/

@Data
public class PromoteProductResponse extends ResponseObject {

    private Long id;

     private Integer mini;

     private Integer step;

}