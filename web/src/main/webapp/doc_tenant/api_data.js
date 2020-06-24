define({ "api": [
  {
    "type": "post",
    "url": "/tenantRest/order/month.htm",
    "title": "11.01 月订单量统计",
    "version": "0.0.1",
    "name": "order.month",
    "group": "10static",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "beginDate",
            "description": "<p>开始时间</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "endDate",
            "description": "<p>结束时间</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取系统账户</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "total",
            "description": "<p>总量</p>"
          },
          {
            "group": "Success 200",
            "type": "list",
            "optional": false,
            "field": "list",
            "description": "<p>数据集合</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "list.name",
            "description": "<p>日期</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "list.num",
            "description": "<p>数量</p>"
          }
        ]
      }
    },
    "filename": "./10static.js",
    "groupTitle": "11.0 统计模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/order/month.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/tenantRest/order/num.htm",
    "title": "11.01 日订单量统计",
    "version": "0.0.1",
    "name": "order.num",
    "group": "10static",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "beginDate",
            "description": "<p>开始时间</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "endDate",
            "description": "<p>结束时间</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取系统账户</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "total",
            "description": "<p>总量</p>"
          },
          {
            "group": "Success 200",
            "type": "list",
            "optional": false,
            "field": "list",
            "description": "<p>数据集合</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "list.name",
            "description": "<p>日期</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "list.num",
            "description": "<p>数量</p>"
          }
        ]
      }
    },
    "filename": "./10static.js",
    "groupTitle": "11.0 统计模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/order/num.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/employee/create.htm",
    "title": "1.01 创建员工",
    "version": "0.0.1",
    "name": "1user.create",
    "group": "1user",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "no",
            "description": "<p>登录账号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>email</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "job",
            "description": "<p>职务</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "department",
            "description": "<p>部门id</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>创建员工</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./1user.js",
    "groupTitle": "1.0 用户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/employee/create.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/employee/delete.htm",
    "title": "1.04 删除员工",
    "version": "0.0.1",
    "name": "1user.delete",
    "group": "1user",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "id",
            "description": "<p>员工id</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>删除员工</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./1user.js",
    "groupTitle": "1.0 用户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/employee/delete.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/employee/search.htm",
    "title": "1.03 员工搜索",
    "version": "0.0.1",
    "name": "1user.search",
    "group": "1user",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "account",
            "description": "<p>账号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "department",
            "description": "<p>部门id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "no",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>分页大小</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新员工信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./1user.js",
    "groupTitle": "1.0 用户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/employee/search.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/employee/update.htm",
    "title": "1.02 更新员工信息",
    "version": "0.0.1",
    "name": "1user.update",
    "group": "1user",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>email</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "job",
            "description": "<p>职务</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "department",
            "description": "<p>部门id</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新员工信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./1user.js",
    "groupTitle": "1.0 用户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/employee/update.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customer/create.htm",
    "title": "1.01 创建客户",
    "version": "0.0.1",
    "name": "2customer.create",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "no",
            "description": "<p>登录账号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>联系人</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "shop",
            "description": "<p>客户名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "job",
            "description": "<p>职务</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>创建客户</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customer/create.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customer/delete.htm",
    "title": "1.04 删除客户",
    "version": "0.0.1",
    "name": "2customer.delete",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "long",
            "description": "<p>id</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>删除客户</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customer/delete.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customer/search.htm",
    "title": "1.03 客户搜索",
    "version": "0.0.1",
    "name": "2customer.search",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "account",
            "description": "<p>账号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "no",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>分页大小</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新客户信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customer/search.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customer/update.htm",
    "title": "1.02 更新客户信息",
    "version": "0.0.1",
    "name": "2customer.update",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "shop",
            "description": "<p>客户名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新客户信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customer/update.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customeraddress/create.htm",
    "title": "1.05 添加地址",
    "version": "0.0.1",
    "name": "customeraddress.create",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "user",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "name",
            "description": "<p>联系人</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "tel",
            "description": "<p>座机</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "lat",
            "description": "<p>维度</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "lng",
            "description": "<p>经度</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "code",
            "description": "<p>邮政编码</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "note",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "defaultState",
            "description": "<p>是否默认 1(是) 0(不是)</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>创建客户</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customeraddress/create.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customeraddress/delete.htm",
    "title": "1.08 删除地址",
    "version": "0.0.1",
    "name": "customeraddress.delete",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "id",
            "description": "<p>地址id</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>删除地址</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customeraddress/delete.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customeraddress/search.htm",
    "title": "1.07 地址搜索",
    "version": "0.0.1",
    "name": "customeraddress.search",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "no",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>分页大小</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新客户信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customeraddress/search.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/customeraddress/update.htm",
    "title": "1.06 更新地址信息",
    "version": "0.0.1",
    "name": "customeraddress.update",
    "group": "2customer",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "name",
            "description": "<p>联系人</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "tel",
            "description": "<p>座机</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "lat",
            "description": "<p>维度</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "lng",
            "description": "<p>经度</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "code",
            "description": "<p>邮政编码</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "note",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新客户信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./2customer.js",
    "groupTitle": "2.0 客户模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/customeraddress/update.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/productSpec/add.htm",
    "title": "3.02 对某个规格添加规格值",
    "version": "0.0.1",
    "name": "3product.add",
    "group": "3product",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>规格id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>规格值</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>对某个规格添加规格值</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./3product.js",
    "groupTitle": "3.0 商品模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/productSpec/add.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/productSpec/list.htm",
    "title": "3.01 获取商品规格",
    "version": "0.0.1",
    "name": "3product.list",
    "group": "3product",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "tenant",
            "description": "<p>平台id(3)</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>数据量</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取商品规格</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "array",
            "optional": false,
            "field": "list",
            "description": "<p>数据集合</p>"
          },
          {
            "group": "Success 200",
            "type": "long",
            "optional": false,
            "field": "list.id",
            "description": "<p>id 任务id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "list.label",
            "description": "<p>规格名称</p>"
          },
          {
            "group": "Success 200",
            "type": "array",
            "optional": false,
            "field": "list.items",
            "description": "<p>规格值集合</p>"
          },
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "list.items.id",
            "description": "<p>规格值id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "list.items.name",
            "description": "<p>规格值</p>"
          }
        ]
      }
    },
    "filename": "./3product.js",
    "groupTitle": "3.0 商品模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/productSpec/list.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/product/create.htm",
    "title": "3.03 创建商品",
    "version": "0.0.1",
    "name": "product.create",
    "group": "3product",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "brand",
            "description": "<p>品牌</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "catalog",
            "description": "<p>分类</p>"
          },
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "label",
            "description": "<p>标签id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>编码</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>创建商品</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./3product.js",
    "groupTitle": "3.0 商品模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/product/create.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/product/delete.htm",
    "title": "3.06 删除商品",
    "version": "0.0.1",
    "name": "product.delete",
    "group": "3product",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "id",
            "description": "<p>商品id</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>删除商品</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./3product.js",
    "groupTitle": "3.0 商品模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/product/delete.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/product/search.htm",
    "title": "3.05 商品搜索",
    "version": "0.0.1",
    "name": "product.search",
    "group": "3product",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "no",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>分页大小</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新商品信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./3product.js",
    "groupTitle": "3.0 商品模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/product/search.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/tenantRest/product/update.htm",
    "title": "3.04 更新商品信息",
    "version": "0.0.1",
    "name": "product.update",
    "group": "3product",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "brand",
            "description": "<p>品牌</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "catalog",
            "description": "<p>分类</p>"
          },
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "label",
            "description": "<p>标签id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>编码</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新商品信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./3product.js",
    "groupTitle": "3.0 商品模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/product/update.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/financeAccount/add.htm",
    "title": "4.03 余额增加",
    "version": "0.0.1",
    "name": "add",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "user",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "float",
            "optional": false,
            "field": "account",
            "description": "<p>金额</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "note",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>余额增加</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/financeAccount/add.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/financeAccount/addScore.htm",
    "title": "4.06 积分增加",
    "version": "0.0.1",
    "name": "addScore",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "user",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "float",
            "optional": false,
            "field": "account",
            "description": "<p>积分</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "note",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>积分增加</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/financeAccount/addScore.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/financeAccount/deduct.htm",
    "title": "4.04 余额减少",
    "version": "0.0.1",
    "name": "deduct",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "user",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "float",
            "optional": false,
            "field": "account",
            "description": "<p>金额</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "note",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>余额增加</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/financeAccount/deduct.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/financeAccount/deductScore.htm",
    "title": "4.07 积分减少",
    "version": "0.0.1",
    "name": "deductScore",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "user",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "float",
            "optional": false,
            "field": "account",
            "description": "<p>积分</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "note",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>余额增加</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/financeAccount/deductScore.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/financeAccount/score.htm",
    "title": "4.05 获取积分账户",
    "version": "0.0.1",
    "name": "score",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "tenant",
            "description": "<p>tenant</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "no",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>大小</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取积分账户</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "list",
            "optional": false,
            "field": "list",
            "description": "<p>数据集合</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/financeAccount/score.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/financeAccount/search.htm",
    "title": "4.01 获取系统账户",
    "version": "0.0.1",
    "name": "search",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "tenant",
            "description": "<p>tenant</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "no",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>大小</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取系统账户</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "list",
            "optional": false,
            "field": "list",
            "description": "<p>数据集合</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/financeAccount/search.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/cash/stream.htm",
    "title": "4.08 资金流水",
    "version": "0.0.1",
    "name": "stream",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "id",
            "description": "<p>账号id</p>"
          },
          {
            "group": "Parameter",
            "type": "date",
            "optional": false,
            "field": "beginDate",
            "description": "<p>开始时间</p>"
          },
          {
            "group": "Parameter",
            "type": "date",
            "optional": false,
            "field": "endDate",
            "description": "<p>结束时间</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "no",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "size",
            "description": "<p>大小</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>资金流水</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "array",
            "optional": false,
            "field": "list",
            "description": "<p>数据集合</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/cash/stream.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/rest/financeAccount/updateCredit.htm",
    "title": "4.02 更新某人的信用额度",
    "version": "0.0.1",
    "name": "updateCredit",
    "group": "4finance",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "long",
            "optional": false,
            "field": "user",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "float",
            "optional": false,
            "field": "credit",
            "description": "<p>信用额度</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新某人的信用额度</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./4finance.js",
    "groupTitle": "4.0 财务模块",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/rest/financeAccount/updateCredit.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/tenantRest/department/company.htm",
    "title": "10.06 获取公司部门以及下级的所有部门",
    "version": "0.0.1",
    "name": "company",
    "group": "department",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>部门名称</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取公司部门以及下级的所有部门</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./department.js",
    "groupTitle": "10.0 部门管理",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/department/company.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/tenantRest/department/create.htm",
    "title": "10.01 创建部门",
    "version": "0.0.1",
    "name": "create",
    "group": "department",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>部门名称</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "parent",
            "description": "<p>父部门id，没有不需要添加</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>创建部门</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>部门id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>部门名称</p>"
          }
        ]
      }
    },
    "filename": "./department.js",
    "groupTitle": "10.0 部门管理",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/department/create.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/tenantRest/department/delete.htm",
    "title": "10.03 删除部门",
    "version": "0.0.1",
    "name": "delete",
    "group": "department",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>部门id</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>删除部门</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./department.js",
    "groupTitle": "10.0 部门管理",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/department/delete.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/tenantRest/department/list.htm",
    "title": "10.04 部门列表",
    "version": "0.0.1",
    "name": "list",
    "group": "department",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "parent",
            "description": "<p>父部门id，没有可以不传</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>删除部门</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./department.js",
    "groupTitle": "10.0 部门管理",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/department/list.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/tenantRest/department/search.htm",
    "title": "10.05 部门搜索",
    "version": "0.0.1",
    "name": "search",
    "group": "department",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>部门名称</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>部门搜索</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./department.js",
    "groupTitle": "10.0 部门管理",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/department/search.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/tenantRest/department/update.htm",
    "title": "10.02 更新部门信息",
    "version": "0.0.1",
    "name": "update",
    "group": "department",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>部门id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>部门名称</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>更新部门信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          }
        ]
      }
    },
    "filename": "./department.js",
    "groupTitle": "10.0 部门管理",
    "sampleRequest": [
      {
        "url": "https://cloud.demomall.cn/b2b/tenantRest/department/update.htm"
      }
    ]
  }
] });
