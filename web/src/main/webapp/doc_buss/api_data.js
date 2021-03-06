define({ "api": [
  {
    "type": "get",
    "url": "/rest/buss/info.htm",
    "title": "6.03 获取商家信息",
    "version": "0.0.1",
    "name": "buss_info",
    "group": "6business",
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
            "type": "String",
            "optional": false,
            "field": "userToken",
            "description": "<p>用户令牌</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>商家登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>商家名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "logo",
            "description": "<p>商家logo</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>商家地址</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "lng",
            "description": "<p>经度</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "lat",
            "description": "<p>纬度</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "saleNum",
            "description": "<p>消费次数</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "vipNum",
            "description": "<p>消费人数</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "money",
            "description": "<p>收入</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "sale",
            "description": "<p>销售金额</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "venueType",
            "description": "<p>商家内容</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "deduction",
            "description": "<p>商家折扣</p>"
          }
        ]
      }
    },
    "filename": "./6business.js",
    "groupTitle": "1.商家模块",
    "sampleRequest": [
      {
        "url": "https://umall.haoxuer.com/bigworld/rest/buss/info.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/buss/license.htm",
    "title": "6.07 获取协议",
    "version": "0.0.1",
    "name": "buss_license",
    "group": "6business",
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
            "type": "String",
            "optional": false,
            "field": "userToken",
            "description": "<p>用户令牌</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>商家登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "note",
            "description": "<p>协议</p>"
          }
        ]
      }
    },
    "filename": "./6business.js",
    "groupTitle": "1.商家模块",
    "sampleRequest": [
      {
        "url": "https://umall.haoxuer.com/bigworld/rest/buss/license.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/buss/orders.htm",
    "title": "6.04 商家销售信息所搜",
    "version": "0.0.1",
    "name": "buss_orders",
    "group": "6business",
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
            "type": "String",
            "optional": false,
            "field": "userToken",
            "description": "<p>用户令牌</p>"
          },
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
    "description": "<p>商家登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "totalNum",
            "description": "<p>消费人数</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "totalMoney",
            "description": "<p>收入</p>"
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
            "type": "String",
            "optional": false,
            "field": "list.date",
            "description": "<p>日期</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "list.name",
            "description": "<p>消费姓名</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "list.payType",
            "description": "<p>支付方式</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "list.money",
            "description": "<p>消费金额</p>"
          }
        ]
      }
    },
    "filename": "./6business.js",
    "groupTitle": "1.商家模块",
    "sampleRequest": [
      {
        "url": "https://umall.haoxuer.com/bigworld/rest/buss/orders.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/buss/push.htm",
    "title": "6.06 商家推送消息",
    "version": "0.0.1",
    "name": "buss_push",
    "group": "6business",
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
            "type": "String",
            "optional": false,
            "field": "tag",
            "description": "<p>标签</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "note",
            "description": "<p>推送内容</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "userToken",
            "description": "<p>用户令牌</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>商家登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
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
    "filename": "./6business.js",
    "groupTitle": "1.商家模块",
    "sampleRequest": [
      {
        "url": "https://umall.haoxuer.com/bigworld/rest/buss/push.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/buss/statistic.htm",
    "title": "6.05 商家销售统计",
    "version": "0.0.1",
    "name": "buss_statistic",
    "group": "6business",
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
            "type": "String",
            "optional": false,
            "field": "userToken",
            "description": "<p>用户令牌</p>"
          },
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
    "description": "<p>商家登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>状态消息</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "totalSaleNum",
            "description": "<p>消费次数</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "totalVipNum",
            "description": "<p>消费人数</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "totalMoney",
            "description": "<p>收入</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "totalSale",
            "description": "<p>销售金额</p>"
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
            "type": "String",
            "optional": false,
            "field": "list.date",
            "description": "<p>日期</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "list.saleNum",
            "description": "<p>消费次数</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "list.vipNum",
            "description": "<p>消费人数</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "list.money",
            "description": "<p>收入</p>"
          },
          {
            "group": "Success 200",
            "type": "float",
            "optional": false,
            "field": "list.sale",
            "description": "<p>销售金额</p>"
          }
        ]
      }
    },
    "filename": "./6business.js",
    "groupTitle": "1.商家模块",
    "sampleRequest": [
      {
        "url": "https://umall.haoxuer.com/bigworld/rest/buss/statistic.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/saas_user/login.htm",
    "title": "6.01 商家登陆",
    "version": "0.0.1",
    "name": "login",
    "group": "6business",
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
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>商家登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userToken",
            "description": "<p>用户令牌</p>"
          }
        ]
      }
    },
    "filename": "./6business.js",
    "groupTitle": "1.商家模块",
    "sampleRequest": [
      {
        "url": "https://umall.haoxuer.com/bigworld/rest/saas_user/login.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/rest/saas_user/updatePassword.htm",
    "title": "6.02 更新密码",
    "version": "0.0.1",
    "name": "updatePassword",
    "group": "6business",
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
            "type": "String",
            "optional": false,
            "field": "userToken",
            "description": "<p>用户令牌</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "oldPassword",
            "description": "<p>老密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>商家登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
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
    "filename": "./6business.js",
    "groupTitle": "1.商家模块",
    "sampleRequest": [
      {
        "url": "https://umall.haoxuer.com/bigworld/rest/saas_user/updatePassword.htm"
      }
    ]
  }
] });
