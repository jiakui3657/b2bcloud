/**
 * @apiDefine 2customer 2.0 客户模块
 */



/**
 * @api {get} /tenantRest/customer/create.htm 1.01 创建客户
 *
 * @apiVersion 0.0.1
 *
 * @apiName 2customer.create
 *
 * @apiGroup 2customer
 *
 *
 * @apiParam {String} no 登录账号
 *
 * @apiParam {String} password 密码
 * 
 * @apiParam {String} name 联系人
 * 
 * @apiParam {String} phone 手机号
 * 
 * @apiParam {String} shop 客户名称
 * 
 * @apiParam {String} job 职务
 * 
 * @apiParam {String} sex 性别
 * 
 *
 * @apiPermission none
 *
 * @apiDescription 创建客户
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


 /**
 * @api {get} /tenantRest/customer/update.htm 1.02 更新客户信息
 *
 * @apiVersion 0.0.1
 *
 * @apiName 2customer.update
 *
 * @apiGroup 2customer
 *
 *
 * @apiParam {String} name 姓名
 * 
 * @apiParam {String} phone 手机号
 * 
 * @apiParam {String} shop 客户名称
 * 
 * @apiParam {String} sex 性别
 * 
 *
 * @apiPermission none
 *
 * @apiDescription 更新客户信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */




 /**
 * @api {get} /tenantRest/customer/search.htm 1.03 客户搜索
 *
 * @apiVersion 0.0.1
 *
 * @apiName 2customer.search
 *
 * @apiGroup 2customer
 *
 *
 * @apiParam {String} name 姓名
 * 
 * @apiParam {String} phone 手机号
 * 
 * @apiParam {String} account 账号
 * 
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 分页大小
 *
 * @apiPermission none
 *
 * @apiDescription 更新客户信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


  /**
 * @api {get} /tenantRest/customer/delete.htm 1.04 删除客户
 *
 * @apiVersion 0.0.1
 *
 * @apiName 2customer.delete
 *
 * @apiGroup 2customer
 *
 * @apiParam {int} long id
 *
 * @apiPermission none
 *
 * @apiDescription 删除客户
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */



 
/**
 * @api {get} /tenantRest/customeraddress/create.htm 1.05 添加地址
 *
 * @apiVersion 0.0.1
 *
 * @apiName customeraddress.create
 *
 * @apiGroup 2customer
 * 
 *  @apiParam {int} user 用户id
 *
 * @apiParam {int} name 联系人
 * 
 * @apiParam {int} phone 手机号
 * 
 * @apiParam {int} tel 座机
 * 
 * @apiParam {int} address 地址
 * 
 * @apiParam {int} lat 维度
 * 
 * @apiParam {int} lng 经度
 * 
 * @apiParam {string} code 邮政编码
 * 
 * @apiParam {string} note 备注
 * 
 * @apiParam {string} defaultState 是否默认 1(是) 0(不是)
 * 
 *
 * @apiPermission none
 *
 * @apiDescription 创建客户
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


 /**
 * @api {get} /tenantRest/customeraddress/update.htm 1.06 更新地址信息
 *
 * @apiVersion 0.0.1
 *
 * @apiName customeraddress.update
 *
 * @apiGroup 2customer
 *
 *
 * @apiParam {int} name 联系人
 * 
 * @apiParam {int} phone 手机号
 * 
 * @apiParam {int} tel 座机
 * 
 * @apiParam {int} address 地址
 * 
 * @apiParam {int} lat 维度
 * 
 * @apiParam {int} lng 经度
 * 
 * @apiParam {string} code 邮政编码
 * 
 * @apiParam {string} note 备注
 * 
 * 
 *
 * @apiPermission none
 *
 * @apiDescription 更新客户信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */




 /**
 * @api {get} /tenantRest/customeraddress/search.htm 1.07 地址搜索
 *
 * @apiVersion 0.0.1
 *
 * @apiName customeraddress.search
 *
 * @apiGroup 2customer
 *
 *
 * @apiParam {String} name 姓名
 * 
 * 
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 分页大小
 *
 * @apiPermission none
 *
 * @apiDescription 更新客户信息
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


  /**
 * @api {get} /tenantRest/customeraddress/delete.htm 1.08 删除地址
 *
 * @apiVersion 0.0.1
 *
 * @apiName customeraddress.delete
 *
 * @apiGroup 2customer
 *
 * @apiParam {long}  id 地址id
 *
 * @apiPermission none
 *
 * @apiDescription 删除地址
 * 
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */
 