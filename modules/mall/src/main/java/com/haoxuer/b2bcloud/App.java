package com.haoxuer.b2bcloud;

import com.haoxuer.b2bcloud.order.data.entity.OrderRefundItem;
import com.haoxuer.b2bcloud.order.data.entity.OrderTally;
import com.haoxuer.bigworld.generate.TenantMake;
import com.haoxuer.bigworld.generate.template.hibernate.TemplateHibernateDir;
import com.haoxuer.bigworld.generate.templates.elementui.ElementUIDir;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TenantMake make = new TenantMake(ElementUIDir.class, TemplateHibernateDir.class);
        //make.setBase("com.haoxuer.b2bcloud.promote");
        File view = new File("E:\\codes\\clouds\\b2bcloud\\web\\src\\main\\webapp\\WEB-INF\\ftl\\tenant\\default");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        cs.add(OrderRefundItem.class);


        make.setMenus("1,61,91");
        make.setDao(true);
        make.setService(false);
        make.setView(false);
        make.setAction(false);
        make.setApi(false);
        make.setRest(false);
        make.makes(cs);
    }
}
