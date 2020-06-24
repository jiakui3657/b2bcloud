package com.haoxuer.b2bcloud.promote.app;

import com.haoxuer.b2bcloud.promote.data.entity.Promote;

public class Apps {

    public static void main(String[] args) {

        String name = Promote.class.getName();
        System.out.println(name);
        int len = name.indexOf("data.entity");
        System.out.println(name.substring(0,len-1));
    }
}
