/**
 * @apiDefine 1user 1.0 用户模块
 */



/**
 * @api {get} /rest/saas_user/login.htm 1.01 登录接口
 *
 * @apiVersion 0.0.1
 *
 * @apiName login
 *
 * @apiGroup 1user
 *
 *  @apiParam {int} tenant 平台id(3)
 *
 * @apiParam {String} username 用户名
 *
 * @apiParam {String} password 密码
 *
 *
 * @apiPermission none
 *
 * @apiDescription 登录接口
 *
 * @apiSuccess {String} userToken 用户令牌
 */

/**
 * @api {get} /rest/saas_user/updatePassword.htm 1.02 更新密码
 *
 * @apiVersion 0.0.1
 *
 * @apiName updatePassword
 *
 * @apiGroup 1user
 *
 * @apiParam {int} tenant 平台id(3)
 *
 * @apiParam {String} userToken 用户令牌
 *
 * @apiParam {String} oldPassword 老密码
 *
 * @apiParam {String} password 密码
 *
 *
 * @apiPermission none
 *
 * @apiDescription 更新密码
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 */


/**
 * @api {get} /rest/ad/position.htm 1.03 获取某个类型的广告
 *
 * @apiVersion 0.0.1
 *
 * @apiName ad.position
 *
 * @apiGroup 1user
 *
 * @apiParam {int} tenant 平台id(2)
 *
 * @apiParam {String} userToken 用户令牌
 * @apiParam {String} id 类型id
 *
 * @apiPermission none
 *
 * @apiDescription 获取某个类型的广告
 *
 * @apiSuccess {int} code 状态码
 *
 * @apiSuccess {String} msg 状态消息
 *
 */


 /**
  * @api {get} /rest/saas_user/findOpenId.htm 1.04 获取openId
  *
  * @apiVersion 0.0.1
  *
  * @apiName findOpenId
  *
  * @apiGroup 1user
  *
  *  @apiParam {int} tenant 平台id(3)
  *
  * @apiParam {String} type 第三方类型(wxapp为小程序登录)
  *
  * @apiParam {String} code 第三方code
  *
  *
  * @apiPermission none
  *
  * @apiDescription 获取openId
  *
  * @apiSuccess {String} openId 用户的openId
  */


  /**
  * @api {get} /rest/customer/create.htm 1.05 用户注册
  *
  * @apiVersion 0.0.1
  *
  * @apiName customer.create
  *
  * @apiGroup 1user
  *
  * @apiParam {int} tenant 平台id(3)
  *
  * @apiParam {String} no 账号
  *
  * @apiParam {String} password 密码
  *
  * @apiParam {String} name 姓名
  * 
  * @apiParam {String} phone 电话
  * 
  * @apiParam {String} shop 经销商名称
  *
  * @apiPermission none
  *
  * @apiDescription 用户注册
  *
  * @apiSuccess {int} code 状态码
  */
