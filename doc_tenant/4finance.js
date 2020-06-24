/**
 * @apiDefine 4finance 4.0 财务模块
 */

/**
 * @api {post} /rest/financeAccount/search.htm 4.01 获取系统账户
 *
 * @apiVersion 0.0.1
 *
 * @apiName search
 *
 * @apiGroup 4finance
 *
 * @apiParam {int} tenant tenant
 *  
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 大小
 *
 * @apiPermission none
 *
 * @apiDescription 获取系统账户
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
 * @api {post} /rest/financeAccount/updateCredit.htm 4.02 更新某人的信用额度
 *
 * @apiVersion 0.0.1
 *
 * @apiName updateCredit
 *
 * @apiGroup 4finance
 *
 * @apiParam {long} user 用户id
 *
 * @apiParam {float} credit 信用额度
 *
 * @apiPermission none
 *
 * @apiDescription 更新某人的信用额度
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 */



/**
 * @api {post} /rest/financeAccount/add.htm 4.03 余额增加
 *
 * @apiVersion 0.0.1
 *
 * @apiName add
 *
 * @apiGroup 4finance
 *
 * @apiParam {long} user 用户id
 *
 * @apiParam {float} account 金额
 * @apiParam {string} note 备注
 * @apiPermission none
 *
 * @apiDescription 余额增加
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 */

 /**
  * @api {post} /rest/financeAccount/deduct.htm 4.04 余额减少
  *
  * @apiVersion 0.0.1
  *
  * @apiName deduct
  *
  * @apiGroup 4finance
  *
  * @apiParam {long} user 用户id
  *
  * @apiParam {float} account 金额
  * @apiParam {string} note 备注
  * @apiPermission none
  *
  * @apiDescription 余额增加
  *
  * @apiSuccess {Int} code 状态码(默认为0)
  *
  * @apiSuccess {string} msg 状态消息
  *
  */

  /**
 * @api {post} /rest/financeAccount/score.htm 4.05 获取积分账户
 *
 * @apiVersion 0.0.1
 *
 * @apiName score
 *
 * @apiGroup 4finance
 *
 * @apiParam {int} tenant tenant
 *  
 * @apiParam {int} no 页码
 * 
 * @apiParam {int} size 大小
 *
 * @apiPermission none
 *
 * @apiDescription 获取积分账户
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
 * @api {post} /rest/financeAccount/addScore.htm 4.06 积分增加
 *
 * @apiVersion 0.0.1
 *
 * @apiName addScore
 *
 * @apiGroup 4finance
 *
 * @apiParam {long} user 用户id
 *
 * @apiParam {float} account 积分
 * 
 * @apiParam {string} note 备注
 * 
 * @apiPermission none
 *
 * @apiDescription 积分增加
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 */

 /**
  * @api {post} /rest/financeAccount/deductScore.htm 4.07 积分减少
  *
  * @apiVersion 0.0.1
  *
  * @apiName deductScore
  *
  * @apiGroup 4finance
  *
  * @apiParam {long} user 用户id
  *
  * @apiParam {float} account 积分
  * 
  * @apiParam {string} note 备注
  * 
  * @apiPermission none
  *
  * @apiDescription 余额增加
  *
  * @apiSuccess {Int} code 状态码(默认为0)
  *
  * @apiSuccess {string} msg 状态消息
  *
  */


  
 /**
  * @api {post} /rest/cash/stream.htm 4.08 资金流水
  *
  * @apiVersion 0.0.1
  *
  * @apiName stream
  *
  * @apiGroup 4finance
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