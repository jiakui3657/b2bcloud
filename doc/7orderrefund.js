/**
 * @apiDefine 7orderrefund 7.0 退货模块
 */

/**
 * @api {post} /rest/orderrefund/create.htm 7.01 创建退货单
 *
 * @apiVersion 0.0.1
 *
 * @apiName orderrefund.create
 *
 * @apiGroup 7orderrefund
 *
 * @apiParam {int} tenant tenant
 *
 * @apiParam {String} userToken 用户令牌
 * 
 * @apiParam {Long} orderId 订单id
 *
*  @apiParamExample {json} Request-Example:
*     {
*       "items":{"id":15,"num":10},
*        orderId:""
*     }
*
 *
 * @apiPermission none
 *
 * @apiDescription 创建退货单
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 *
 */


/**
 * @api {post} /rest/orderrefund/search.htm 7.02 退货单搜索
 *
 * @apiVersion 0.0.1
 *
 * @apiName search
 *
 * @apiGroup 7orderrefund
 *
 *
 * @apiParam {String} auditState init审核中,success审核成功,fail审核失败
 *
 * @apiParam {int} no 页码
 *
 * @apiParam {int} size 大小
 * 
 * @apiParam {int} tenant tenant
 *
 * @apiParam {String} userToken 用户令牌
 *
 * @apiPermission none
 *
 * @apiDescription 退货单搜索
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {string} msg 状态消息
 *
 * @apiSuccess {array} list 数据集合
 * 
 * @apiSuccess {String} list.id 退货项id
 * 
 * @apiSuccess {String} list.name 商品名称
 * 
 * @apiSuccess {String} list.logo 商品logo
 * 
 * @apiSuccess {String} list.num 退货数量
 *
 */

