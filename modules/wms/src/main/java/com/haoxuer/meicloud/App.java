package com.haoxuer.meicloud;

import com.haoxuer.bigworld.generate.TenantMake;
import com.haoxuer.bigworld.generate.template.hibernate.TemplateHibernateDir;
import com.haoxuer.bigworld.generate.templates.adminlte.TemplateAdminLTE;
import com.haoxuer.meicloud.wms.data.entity.Good;
import com.haoxuer.meicloud.wms.data.entity.Warehouse;
import com.haoxuer.meicloud.wms.data.entity.WarehouseCatalog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        TenantMake make = new TenantMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setBase("com.haoxuer.meicloud.wms");
        File view = new File("E:\\codes\\maven\\meicloud\\web\\src\\main\\webapp\\WEB-INF\\ftl\\tenant");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        cs.add(Warehouse.class);
        make.setMenus("1,79,80");
        make.setDao(true);
        make.setService(true);
        make.setView(true);
        make.setAction(true);
        make.setApi(true);
        make.makes(cs);
    }
}
