/**
 * @apiDefine 6address 6.0 地址模块
 */

/**
 * @api {post} /rest/address/page.htm 6.01 获取用户的地址
 *
 * @apiVersion 0.0.1
 *
 * @apiName page
 *
 * @apiGroup 6address
 *
 * @apiParam {String} userToken 用户令牌
 * 
 * @apiParam {int} tenant tenant
 *  
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 大小
 *
 * @apiPermission none
 *
 * @apiDescription 获取用户的地址
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 * @apiSuccess {list} list  数据集合
 *
 *
 */


 
/**
 * @api {post} /rest/address/add.htm 6.02 添加地址
 *
 * @apiVersion 0.0.1
 *
 * @apiName add
 *
 * @apiGroup 6address
 *
 * @apiParam {String} userToken 用户令牌
 * 
 * @apiParam {int} tenant tenant
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
 * @apiPermission none
 *
 * @apiDescription 添加地址
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 *
 */


 
/**
 * @api {post} /rest/address/update.htm 6.03 更新地址
 *
 * @apiVersion 0.0.1
 *
 * @apiName update
 *
 * @apiGroup 6address
 *
 * @apiParam {String} userToken 用户令牌
 * 
 * @apiParam {int} tenant tenant
 * 
 * @apiParam {int} id 地址id
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
 * @apiPermission none
 *
 * @apiDescription 更新地址
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 *
 */


 
/**
 * @api {post} /rest/address/delete.htm 6.04 删除地址
 *
 * @apiVersion 0.0.1
 *
 * @apiName delete
 *
 * @apiGroup 6address
 *
 * @apiParam {String} userToken 用户令牌
 * 
 * @apiParam {int} tenant tenant
 * 
 * @apiParam {int} id 地址id
 *  
 * @apiPermission none
 *
 * @apiDescription 删除地址
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 *
 */


 /**
 * @api {post} /rest/address/info.htm 6.04 获取用户的默认地址
 *
 * @apiVersion 0.0.1
 *
 * @apiName delete
 *
 * @apiGroup 6address
 *
 * @apiParam {String} userToken 用户令牌
 * 
 * @apiParam {int} tenant tenant
 * 
 * @apiPermission none
 *
 * @apiDescription 获取用户的默认地址
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 * @apiSuccess {int} id 地址id
 *  
 * @apiSuccess {int} name 联系人
 * 
 * @apiSuccess {int} phone 手机号
 * 
 * @apiSuccess {int} tel 座机
 * 
 * @apiSuccess {int} address 地址
 * 
 * @apiSuccess {int} lat 维度
 * 
 * @apiSuccess {int} lng 经度
 * 
 * @apiSuccess {string} code 邮政编码
 * 
 * @apiSuccess {string} note 备注
 */

