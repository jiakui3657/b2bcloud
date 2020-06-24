package com.haoxuer.meicloud;

import com.haoxuer.bigworld.generate.TenantMake;
import com.haoxuer.bigworld.generate.template.hibernate.TemplateHibernateDir;
import com.haoxuer.bigworld.generate.templates.adminlte.TemplateAdminLTE;

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
        TenantMake make = new TenantMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
        make.setBase("com.haoxuer.meicloud.crm");
        File view = new File("E:\\codes\\maven\\bigworld\\web\\src\\main\\webapp\\WEB-INF\\ftl\\tenant");
        make.setView(view);

        List<Class<?>> cs = new ArrayList<Class<?>>();
        make.setMenus("1,57,60");
        make.setDao(true);
        make.setService(true);
        make.setView(false);
        make.setAction(true);
        make.setApi(true);
        make.makes(cs);
    }
}
