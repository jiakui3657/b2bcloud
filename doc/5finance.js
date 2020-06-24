/**
 * @apiDefine 5finance 5.0 财务模块
 */

/**
 * @api {post} /rest/financeAccount/accounts.htm 5.01 获取账户信息
 *
 * @apiVersion 0.0.1
 *
 * @apiName accounts
 *
 * @apiGroup 5finance
 *
 * @apiParam {int} tenant tenant
 *
 * @apiParam {String} userToken 用户令牌
 *
 * @apiPermission none
 *
 * @apiDescription 获取账户信息
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 *
 */


/**
 * @api {post} /rest/financeAccount/stream.htm 5.02 资金流水
 *
 * @apiVersion 0.0.1
 *
 * @apiName stream
 *
 * @apiGroup 5finance
 *
 * @apiParam {long} id 账号id
 *
 * @apiParam {date} beginDate 开始时间
 *
 * @apiParam {date} endDate 结束时间
 *
 * @apiParam {int} no 页码
 *
 * @apiParam {int} size 大小
 *
 * @apiParam {String} userToken 用户令牌
 *
 * @apiPermission none
 *
 * @apiDescription 资金流水
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 * @apiSuccess {array} list 数据集合
 *
 */



/**
 * @api {post} /rest/cash/recharge.htm 5.03 充值
 *
 * @apiVersion 0.0.1
 *
 * @apiName recharge
 *
 * @apiGroup 5finance
 *
 * @apiParam {Long} tenant 租户id
 *
 * @apiParam {String} userToken 用户令牌
 *
 * @apiParam {float} money 充值金额
 *
 * @apiParam {String} openId 微信openId
 * 
 * @apiParam {String} payType 支付插件wxapp
 * 
 * 
 * @apiPermission none
 *
 * @apiDescription 充值
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 * @apiSuccess {array} list 数据集合
 *
 */


